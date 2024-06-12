# basic-springboot-2024

java 빅데이터 개발자 과정 Spring Boot 학습 리포지토리

## 1일차

- Spring Boot 개요

  - 개발환경, 개발 난이도를 낮추는 작업
  - Servlet > EJB > JSP > Spring(부흥기) > Spring Boot(끝판왕!!)
  - 장점
    - Spring의 기술을 그대로 사용가능(마이그레이션 간단)
    - JPA를 사용하면 ERD나 DB설계를 하지 않고도 손쉽게 DB 생성 가능
    - Tomcat Webserver가 내장(따로 설치 필요X)
    - 서포트 기능 다수 존재(개발을 쉽게 도와줌)
    - JUnit 테스트, Log4J2 로그도 모두 포함
    - JSP, **Thymeleaf**, Mustache 등.. 편하게 사용가능
    - DB 연동이 무지 쉽다
  - MVC
    <img src="https://raw.githubusercontent.com/zzzissu/basic-springboot-2024/main/images/sp002.png" width="730">

- Spring Boot 개발환경 설정

  - Java JDK 확인 > 17버전 이상

    - https://jdk.java.net/archive/
    - 시스템 속성 > 고급 > 환경변수 중 HAVA_HOME 설정

  - Visual Studio Code
    - VSCodeUserSetup-x64-1.90.0.exe 버전 아님
    - VSCodeSetup-x64-1.90.0.exe 로 설치
    - Extensions(확장.마켓플레이스) > Korean 검색 > Korean Language Pack for Visual Studio Code 설치(한글 패치)
    - Extensions > Java 검색 > Extension Pack for Java 설치(Microsoft)
      - Debugger for Java 등 여섯개 확장팩이 같이 설치
    - Extensions > Spring 검색 > Spring Boot Extension Pack 설치
      - Spring Initializr Java Support 등 3개 확장팩 같이 설치
    - Extensions > Gradle 검색 > Gradle for Java 설치
  - Gradle build tool 설치 고려

    - https://gradle.org/releases/

  - Oracle latest version Docker - 보류

- Spring Boot 프로젝트 생성

  - 메뉴 보기 > 명령 팔레트(Ctrl + Shift + p)

    - Spring InitialLizr: create a Gradel Project...
    - Specify Spring Boot version: 3.2.6
    - specify project language: Java
    - Input Group Id: com.zzzissu(개인적 변경)
    - Input Artifact Id: spring01(대문자 불가)
    - specify packaing type: Jar
    - specify Java version: 17
    - choose dependencies: Selected 0 dependencies
    - 폴더 선택 Diaglog: 원하는 폴더 선택 Generate.. 버튼 선택
    - 오른쪽 하단 팝업에서 Open 버튼 클릭
    - Git 설정 옵션, Language Support for java(TM) by Red Hat 설정 항상버튼 클릭

  - TroubleShooting

    1. 프로젝트 생성이 진행되다 Gradle Connection 에러가 뜨면

    - Extansions > Gradle for Java를 제거
    - VS Code 재시작한 뒤 프로젝트 재생성

    2. Gradle 빌드시 버전 에러로 빌드가 실패하면

    - Gradle build tool 사이트에서 에러에 표시된 버전의 Gradle bt 다운로드
    - 개발 컴퓨터에 설치

    3. ':compileJava' execution failed...

    - JDK 17... error 메세지
    - Java JDK 잘못된 설치 x86(32bit) x64비트 혼용 설치
    - eclipse adoptium jdk 17 새로 설치, 시스템 환경 설정
    - VS Code 재시작
    - biuld.gradle SpringBoot Framework 버전을 다운 3.3.0 -> 3.1.5

  - 프로젝트 생성 후

    - /build.gradle 확인
    - src/main/resources/application.ptoperties(또는 .yaml)확인
    - src/java/groupid/arifactid/Java 소스파일 위치, 작업
    - src/main/resources/프로젝트설정 파일, 웹 리소스 파일(css, js, html, jsp, ...)
    - Spring01Application.java Run | Debug 메뉴
    - Gradle 빌드
      - 터미널에서 .\gradlew.bat 실행
      - Gradle for java(코끼리 아이콘) > Tasks > Build > Build play icon(Run task) 실행
    - spring Boot Dashboard

      - Apps > Spring-1 Run | Debug 중에서 하나 아이콘 클릭 서버 실행
      - 디버그로 실행해야 Hot code replace가 동작!!

        <img src="https://raw.githubusercontent.com/zzzissu/basic-springboot-2024/main/images/sp001.png" width="350">

    - 브라우저 변경설정
      - 설정(Ctrl + ,) > browser > Spring > Dashboard Open With 'Internal' -> 'external'로 변경
      - Chrome 을 기본브라우저 사용 추천

## 2일차

- Oracle 도커로 설치

  - 설치되어있는 Oracle 삭제
  -

  - Database 설정
    - H2 DB : Spring Boot에 내장된 Inmemory DB, Oracle, MySql, SQLServer와 쉽게 호환
    - Oracle: 운영시 사용할 DB
    - MySQL: Optional 설명할 DB
    - Oracle PKNUSB / pknu_p@ss 로 생성
      - 콘솔
      ```shell
      > sqlplus system/password
      SQL>
      ```
