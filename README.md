# simplePetManager 🐾
**서울시 반려동물 시설 정보 통합 플랫폼**

## 💡 프로젝트 소개
흩어져 있는 서울시 내 동물병원, 동물약국, 반려동물 호텔 등의 정보를 한곳에서 확인하고, 위치 기반으로 쉽게 찾아볼 수 있도록 만든 웹 서비스입니다.

* **기간**: 2026.03.04 ~ 2026.04.20
* **목표**: 사용자에게 정확한 시설 정보를 제공하고, 직관적인 검색 경험을 구축하는 것
* **인원**: 3명 (프론트엔드 2명, 백엔드 1명)
---

## 🛠 기술 스택 (Tech Stack)

### **Frontend**
![JSP](https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=java&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)

### **Backend**
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MyBatis](https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=mybatis&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

### **DevOps & Infra**
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Render](https://img.shields.io/badge/Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)

---

## 💻 주요 작업 내용

### **1. 사용자 인증 및 보안**
* **JWT 기반 인증**: Access/Refresh Token을 활용한 무상태 인증 구조 구현
* **이메일 인증**: Brevo API 활용, 5분 제한 타이머 및 인증코드 검증 로직 적용
* **접근 제어**: LoginInterceptor를 통한 비로그인 사용자 및 비정상 접근 제어

### **2. DB 및 쿼리 최적화**
* **모델링**: 회원, 시설, 게시글 데이터 구조 설계 및 MyBatis 연동
* **쿼리 최적화**: #{} (파라미터 바인딩)와 ${} (문자열 치환)의 차이를 이해하고 보안과 성능을 고려한 SQL 작성

### **3. 방어적 프로그래밍과 보안 강화**
* **캐시 제어**: '뒤로가기'를 통한 정보 노출 방지를 위해 응답 헤더에 no-cache, no-store 설정
* **세션 관리**: 다단계 접근 제어 구축 및 비밀번호 수정 완료 시 세션 즉시 파기 로직 적용

---

## 🔍 프로젝트 느낀점
단순히 기능 구현에 그치지 않고, 사용자가 예상치 못한 방식으로 페이지를 이동하거나 새로고침할 때 발생할 수 있는 보안 취약점들을 선제적으로 체크했습니다. 이 과정을 통해 서비스의 무결성을 지키는 방어적 프로그래밍의 중요성을 깊이 체감했습니다.

---

## 🔗 개발자
* **조민영** (minyung0723@gmail.com)
