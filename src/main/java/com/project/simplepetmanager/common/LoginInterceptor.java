package com.project.simplepetmanager.common;

import com.project.simplepetmanager.model.dto.User;
import com.project.simplepetmanager.model.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;
    private final UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,
                             Object handler) throws Exception {

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();

        // 1. 세션 기반 비밀번호 찾기 권한 관리 (메인 이동 시 파기)
        if (uri.equals(contextPath + "/") || uri.equals("/")) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.removeAttribute("verifiedUserId");
            }
        }

        // 2. 보안 페이지 캐시 방지 (뒤로가기 방지)
        if (uri.contains("/passwordEdit") || uri.contains("/myPageEdit")) {
            res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            res.setHeader("Pragma", "no-cache");
            res.setDateHeader("Expires", 0);
        }

        // 3. 로그인 여부 판단 (이미 Filter에서 만료된 토큰은 지워졌으므로 null 체크로 충분)
        String token = cookieUtil.get(req, "access_token");
        boolean isLoggedIn = (token != null);

        // 4. 로그인이 필수인 페이지 접근 차단 (마이페이지, 정보수정 등)
        if (!isLoggedIn && (uri.contains("/myPage") || uri.contains("/board/write"))) {
            res.sendRedirect(contextPath + "/login?error=login_required");
            return false;
        }

        // 5. 비밀번호 수정 페이지 권한 체크 (이메일 인증 세션 확인)
        if (uri.contains("/passwordEdit")) {
            if (!checkPasswordEditAccess(req)) {
                res.sendRedirect(contextPath + "/?error=forbidden");
                return false;
            }
            setLoginUserAttribute(req, token);
            return true;
        }

        // 6. 로그인 된 유저의 불필요한 페이지(로그인/회원가입) 접근 차단
        if (isLoggedIn) {
            if (uri.endsWith("/login") || uri.endsWith("/register") || uri.endsWith("/findUser")) {
                res.sendRedirect(contextPath + "/?LoggedIn=true");
                return false;
            }
            // 공통 유저 정보 셋팅
            setLoginUserAttribute(req, token);
        }

        return true;
    }

    private boolean checkPasswordEditAccess(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) return false;
        String verifiedId = (String) session.getAttribute("verifiedUserId");
        String paramId = req.getParameter("userId");
        return verifiedId != null && verifiedId.equals(paramId);
    }

    private void setLoginUserAttribute(HttpServletRequest req, String token) {
        if (token != null && req.getAttribute("loginUser") == null) {
            String email = jwtUtil.getEmail(token);
            User loginUser = userMapper.login(email);
            if (loginUser != null) {
                req.setAttribute("loginUser", loginUser);
            }
        }
    }
}