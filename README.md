# Spring Boot와 MySQL 연결 demo 프로젝트

## 프로젝트 생성

이 프로젝트는 [Spring Initializr](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.7.15&packaging=jar&jvmVersion=11&groupId=com.example&artifactId=jardemo&name=jardemo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.jardemo&dependencies=web,devtools,thymeleaf,data-jpa,data-jdbc,mysql)를 사용하여 생성되었습니다. 생성 시 사용한 설정은 다음과 같습니다:

- **프로젝트 유형**: Gradle - Groovy
- **프로그래밍 언어**: 자바 (Java 11 버전)
- **스프링 부트 버전**: 2.7.15
- **패키징**: jar

해당 사이트에서 필요한 의존성을 선택하고 프로젝트를 생성할 수 있습니다.

## 프로젝트 구조

- `src/main/java/com/example/demo/`: 주요 코드와 컨트롤러가 위치한 패키지
- `src/main/resources/`: application.properties 파일과 함께 리소스가 위치한 디렉토리
- `src/main/webapp/`: JSP 파일이 위치한 디렉토리

## 주요 클래스 및 파일 설명

- `DemoApplication.java`: 애플리케이션의 시작점
- `RestAPI.java`: CRUD 작업을 위한 REST 엔드포인트를 정의하는 컨트롤러 클래스
- `Book.java`: 책 정보를 표현하는 엔터티 클래스
- `BookRepository.java`: JPA 리포지토리 인터페이스
- `index.jsp`: 책 목록을 표시하는 뷰


## 데이터베이스 설정

이 프로젝트에서는 MySQL 데이터베이스와의 연결을 설정합니다. 데이터베이스 연결을 설정하려면 `application.properties` 파일에서 다음과 같은 속성을 지정해야 합니다.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/example
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

## 데이터베이스 스키마

`books` 테이블을 사용하여 책 정보를 저장합니다. 테이블은 다음과 같은 구조를 가집니다.

- `id`: 자동 증가하는 기본 키
- `title`: 책 제목
- `author`: 저자 이름
- `price`: 책 가격

## 기능

이 애플리케이션은 RESTful API를 사용하여 다음과 같은 기본 CRUD (생성, 읽기, 업데이트, 삭제) 기능을 제공합니다.

- 책 목록 조회 (`GET /books`)
- 책 추가 (`POST /add`)
- 책 수정 (`POST /update/{id}`)
- 책 삭제 (`POST /delete/{id}`)

## 시작 방법

프로젝트를 로컬에서 실행하려면 다음 단계를 수행하세요.

1. MySQL 서버를 시작하고 `example` 스키마와 `books` 테이블을 생성합니다.
2. 필요한 의존성이 포함된 상태에서 프로젝트를 클론 또는 다운로드합니다.
3. `application.properties` 파일을 열고 MySQL 연결 정보를 업데이트합니다.
4. 애플리케이션을 실행하고 웹 브라우저에서 `http://localhost:8081/` 으로 접속합니다.


이것이 프로젝트의 기본 개요입니다. 코드를 자세히 살펴보고 이해하는 데 필요한 추가 정보가 있으면 알려주세요!
