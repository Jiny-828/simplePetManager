# simplePetManager 🐾
**서울시 반려동물 시설 정보 통합 플랫폼**

## 💡 프로젝트 소개
흩어져 있는 서울시 내 동물병원, 동물약국, 반려동물 호텔 등의 정보를 한곳에서 확인하고, 위치 기반으로 쉽게 찾아볼 수 있도록 만든 웹 서비스입니다.

* **기간**: 2026.03.04 ~ 2026.04.20
* **목표**: 사용자에게 정확한 시설 정보를 제공하고, 직관적인 검색 경험을 구축하는 것

---

## 🛠 기술 스택 (Tech Stack)

### **Frontend**
![Java](https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=java&logoColor=white)
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
* JWT(Access/Refresh Token)를 활용해 무상태 인증 구조를 만들었습니다.
* Brevo API로 이메일 인증 기능을 구현했고, 5분 시간 제한과 인증코드 검증 로직을 넣어 인증 과정을 안정화했습니다.
* `LoginInterceptor`를 작성해 비로그인 사용자의 접근을 효율적으로 제어했습니다.

### **2. DB 및 쿼리 최적화**
* MyBatis를 사용하여 회원 정보와 시설 데이터 간의 관계를 설계했습니다.
* SQL 작성 시 `${}`와 `#{}`의 차이를 고려해 보안 문제를 방지하고, 쿼리 실행 속도를 최적화하는 데 신경 썼습니다.

### **3. 방어적 프로그래밍과 보안 강화**
* 비밀번호 변경 등 민감한 페이지에서 브라우저 '뒤로가기'를 통한 정보 노출 이슈를 발견했습니다.
* 이를 해결하기 위해 응답 헤더에 `no-cache`, `no-store`를 설정하고, 처리 완료 후 세션을 즉시 파기하도록 로직을 수정했습니다.

---

## 🔍 프로젝트를 하며 고민했던 점
비밀번호 변경 페이지를 구현하다가 세션 체크가 누락되면 보안상 위험할 수 있겠다는 점을 깨달았습니다. 단순히 '기능이 작동한다'에 그치지 않고, **사용자가 예상치 못한 방식으로 페이지를 이동하거나 새로고침을 할 때 발생할 수 있는 취약점**들을 하나씩 체크하며 보완했습니다. 

이 과정을 통해 단순 구현보다 중요한 것은 서비스의 안정성과 방어적인 코드 설계라는 것을 배울 수 있었습니다.

---

## 🔗 개발자
* **조민영**
