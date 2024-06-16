# 목차
- [섹션 1. 프로젝트 환경 설정](#섹션-1-프로젝트-환경-설정)
  - [1-1. 프로젝트 생성](#1-1-프로젝트-생성)
    - [1-1-1. 웹 어플리케이션 개발 순서](#1-1-1-웹-어플리케이션-개발-순서)
    - [1-1-2. 프로젝트 사용기술](#1-1-2-프로젝트-사용기술)
    - [1-1-3. 이번 강의 핵심 포인트](#1-1-3-이번-강의-핵심-포인트)
    - [1-1-4. Spring Boot 버전 보는법](#1-1-4-spring-boot-버전-보는법)
    - [1-1-4.5. 스프링 부트 기반 프로젝트 생성기](#1-1-45-스프링-부트-기반-프로젝트-생성기)
    - [1-1-5. Project Metadata](#1-1-5-project-metadata)
    - [1-1-6. Dependencies](#1-1-6-dependencies)
    - [1-1-6.5. 프로젝트 열기](#1-1-65-프로젝트-열기)
    - [1-1-7. 프로젝트 구조](#1-1-7-프로젝트-구조)
    - [1-1-8. 스프링 부트 실행 방법](#1-1-8-스프링-부트-실행-방법)
    - [1-1-9. 스프링 부트 빠른 실행 설정](#1-1-9-스프링-부트-빠른-실행-설정)

# 섹션 1. 프로젝트 환경 설정
## 1-1. 프로젝트 생성
### 1-1-1. 웹 어플리케이션 개발 순서
1. 스프링 프로젝트 생성
2. 스프링 부트로 웹 서버 실행
3. 회원 도메인 개발
4. 웹 MVC 개발
5. DB 연동 - JDBC, JPA, 스프링 데이터 JPA
6. 테스트케이스 작성

### 1-1-2. 프로젝트 사용기술
- Spring Boot
- JPA(Java Persistence API)
- Gradle
- HIBERNATE
- Thymeleaf

### 1-1-3. 이번 강의 핵심 포인트
1. 실무 개발 중심
2. 처음부터 끝까지 직접 코딩

- **Maven, Gradle**: 필요한 라이브러리 설치, 빌드, 라이프 사이클 관리 툴
- 실무에선 Gradle을 사용한다.

### 1-1-4. Spring Boot 버전 보는법
- **SNAPSHOT**: 개발 중인 버전
- **M1**: 정식 릴리즈 버전이 아닌 상태
- Spring Boot 3.0 이상의 버전은 Java 17 이상을 설치해야 한다.

### 1-1-4.5. 스프링 부트 기반 프로젝트 생성기
- https://start.spring.io/

### 1-1-5. Project Metadata
- **Group**: 기업명 또는 기업 도메인명 작성
- **Artifact**: build 된 결과물


### 1-1-6. Dependencies
- **Spring Web**: Spring MVC를 사용하여 RESTful을 포함한 웹 애플리케이션을 구축합니다. Apache Tomcat을 기본 내장 컨테이너로 사용합니다.
- **Thymeleaf**: 웹 및 독립형 환경 모두를 위한 최신 서버측 Java 템플릿 엔진입니다. HTML이 브라우저에 정적 프로토타입으로 올바르게 표시되도록 허용합니다.

### 1-1-6.5. 프로젝트 열기
![image](https://github.com/optimal99/hello-spring/assets/96530621/4be2501c-fddd-4837-9533-4ab8c194069a)


### 1-1-7. 프로젝트 구조
**.idea**: IDE가 사용하는 설정 파일
**gradle/wrapper**: gradle 설정 파일
**src**: main과 test 폴더로 구성
- **main**: 실제 개발 코드
  - **resources**: 자바 코드 외의 파일들을 저장하는 폴더(XML, properties, HTML, CSS, JS 등)
    - **static**: 정적 파일들을 저장하는 폴더(CSS, JS, 이미지 등)
    - **templates**: 동적 파일들을 저장하는 폴더(HTML, Thymeleaf 등)
    - **application.properties**: 스프링 부트 설정 파일
- **test**: 테스트 코드
- **build.gradle**: 프로젝트 빌드에 필요한 의존성을 관리하는 파일
  - **plugins**: 플러그인 추가
  - **dependencies**: 의존성 추가
  - **repositories**: 의존성을 다운로드 받을 저장소 추가(기본값은 mavenCentral)
  - **tasks**: 빌드할 때 사용할 태스크 추가
    - **test**: 테스트 코드를 실행할 때 사용하는 태스크
- **gradlew, gradlew.bat**: 윈도우와 리눅스에서 gradle을 실행할 수 있는 스크립트 파일
- **settings.gradle**: 프로젝트 설정 파일

### 1-1-8. 스프링 부트 실행 방법
- **@SpringBootApplication**: 스프링 부트 애플리케이션을 실행할 때 사용하는 어노테이션
  - **SpringApplication.run(HelloSpringApplication.class, args)**: 스프링 부트 애플리케이션을 실행하는 메소드
  - **args**: 프로그램 실행 시 전달받은 인자값을 저장하는 배열
  - 스프링 부트 애플리케이션을 실행하면 내장 톰캣 서버가 실행되고, 웹 애플리케이션이 실행됩니다.
  - 웹 애플리케이션을 실행하면 `http://localhost:8080`으로 접속할 수 있습니다.
  - 실행 단축키: `Ctrl + Shift + F10`

### 1-1-9. 스프링 부트 빠른 실행 설정
- 빌드 및 실행, 테스트 실행의 주체를 Gradle에서 IntelliJ IDEA로 변경한다.
  ![image](https://github.com/optimal99/hello-spring/assets/96530621/2389aef8-96c0-4fb0-ba70-0d38980ea72c)

