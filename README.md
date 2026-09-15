# simplePetManager 🐾
**서울시 반려동물 시설 정보 통합 플랫폼**

## 💡 프로젝트 소개
흩어져 있는 서울시 내 동물병원, 동물약국, 반려동물 호텔 등의 정보를 한곳에서 확인하고, 위치 기반으로 쉽게 찾아볼 수 있도록 만든 웹 서비스입니다.

* **기간**: 2026.03.30 ~ 2026.04.15
* **인원**: 3명 (프론트엔드 2명, 백엔드 1명)
* **팀원**: **이상진 (본인)**, 조민영, 한승현
* **담당 역할**: 리뷰 조회/작성 기능, 북마크 기능 개발
---

## 🛠 기술 스택 (Tech Stack)

### **Backend**
![Java](https://img.shields.io/badge/Java-21-007396?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.4-6DB33F?style=for-the-badge&logo=springboot)
![MyBatis](https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=mybatis)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql)

### **Frontend**
![JSP](https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=java)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)

### **Infra & DevOps**
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle)
![Render](https://img.shields.io/badge/Render-46E3B7?style=for-the-badge&logo=render)

---

## 📋 개발 프로세스

1. Notion을 활용한 프로젝트 일정 및 작업 관리
2. Figma를 활용한 UI 설계, 기능 페이지 제작 및 역할 분담
3. ERDCloud를 활용한 데이터베이스 테이블 설계 (ERD 작성)
4. IntelliJ-GitHub 연동 및 브랜치 생성으로 협업 환경 구축
5. MySQL·MyBatis 연동 및 SQL 테이블 생성
6. **프로젝트 구조 설계 및 리뷰 조회/작성, 북마크 기능 구현 (본인 담당)**
7. 레거시 코드 리팩토링 (ES5 → ES6), 비동기 처리 적용, CSS 네이밍 정리
8. 데이터 추가·병합 과정에서 발생한 오류 분석 및 디버깅
9. Render를 활용한 서버 배포
10. 배포 후 UI 수정 및 기능 안정화

---

## 💻 핵심 기여 내용

![핵심담당](https://img.shields.io/badge/핵심담당-리뷰%2F북마크-4285F4?style=flat-square)

### **1. 리뷰 조회/작성 기능**
* 사용자가 시설별로 리뷰를 조회하고 작성할 수 있는 기능 구현
* 별점(0.5 단위) 데이터를 프론트-백엔드 간 정확하게 주고받기 위한 데이터 타입 처리

### **2. 북마크 기능**
* 관심 시설을 저장하고 관리할 수 있는 북마크 기능 구현
* 사용자별 북마크 상태를 UI와 DB에 동기화

---

## 🔧 트러블슈팅

![문제](https://img.shields.io/badge/문제-FF6B6B?style=flat-square)  
HTTP 400·404·405·500 등 다양한 예외 발생, 리뷰 별점 저장 시 0.5 단위 값이 반올림되는 문제 발생

![원인](https://img.shields.io/badge/원인-FFD93D?style=flat-square)  
엔드포인트(URL) 불일치 및 HTTP 메서드 매핑 오류, 템플릿 리터럴(백틱) 사용 미숙으로 인한 문자열 처리 오류, Float → Integer 변환으로 인한 데이터 타입 불일치 발생

![해결](https://img.shields.io/badge/해결-4CAF50?style=flat-square)  
Chrome 개발자 도구(Network) 및 서버 로그 기반 원인 분석, HTTP 상태 코드별 원인 분류 및 예외 처리, `parseFloat()`·`JSON.stringify()` 적용으로 데이터 타입 유지, `Math.ceil()` 기반 좌표 보정 로직 구현 및 UI·DB 데이터 동기화

---

## 🏗 프로젝트 구조 (Architecture)

```text
simplePetManager/
├── src/main/java/com/project/simplepetmanager/
│   ├── common/           # Security, JwtUtil, Filter, Interceptor
│   ├── controller/       # API(REST) 및 View 컨트롤러
│   ├── model/            # DTO, Mapper, Service(비즈니스 로직)
├── src/main/webapp/      # JSP 뷰 파일
└── Dockerfile            # 멀티 스테이지 빌드 설정
```

---

## 🔍 프로젝트 느낀점
처음 만들어본 프로젝트라 에러를 정말 많이 마주쳤습니다. HTTP 상태 코드부터 데이터 타입 불일치까지 하나씩 원인을 분석하고 고쳐나가면서, 문제를 마주쳤을 때 로그와 개발자 도구를 활용해 원인을 좁혀가는 디버깅 습관을 기를 수 있었습니다.

---

## 🔗 개발자
* **이상진**
