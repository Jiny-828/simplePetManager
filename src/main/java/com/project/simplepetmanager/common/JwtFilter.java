package com.project.simplepetmanager.common;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = cookieUtil.get(request, "access_token");

        if (token != null) {
            if (jwtUtil.isValidToken(token)) {
                // 1. 토큰이 유효한 경우: 인증 정보 셋팅
                String email = jwtUtil.getEmail(token);
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        email,
                        null,
                        List.of(new SimpleGrantedAuthority("ROLE_USER"))
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                // 2. 토큰이 만료된 경우: 브라우저 쿠키 삭제
                log.info("JWT 토큰 만료 감지: 쿠키를 삭제합니다.");
                cookieUtil.delete(response, "access_token");
                // 인증 정보를 셋팅하지 않고 통과시키면 다음 Interceptor에서 처리함
            }
        }

        filterChain.doFilter(request, response);
    }
}
