## 백엔드 프로젝트 README

이 프로젝트는 Spring Boot 기반의 게시판 백엔드 애플리케이션입니다.  
게시글 등록, 목록 조회(페이징 지원), 상세 조회 및 댓글 등록 기능을 제공합니다.

## 주요 기능

- **게시글 등록**: 제목, 내용, 작성자 정보를 입력하여 새 게시글을 등록합니다.
- **게시글 목록 조회**: 게시글 번호, 제목, 작성자, 댓글 수 정보를 페이징 처리하여 반환합니다.
- **게시글 상세 조회**: 선택한 게시글의 상세 내용과 댓글 목록을 확인합니다.
- **댓글 등록**: 게시글에 댓글을 추가합니다.
- **Swagger UI**를 통한 API 문서 제공

## 기술 스택

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MariaDB
- HikariCP
- Swagger (Springdoc)

## 실행 방법

1. **환경 변수 설정**  
   애플리케이션 실행 전에 아래 환경 변수를 설정합니다.
   ```bash
   export DB_URL=jdbc:mariadb://DB의 IP:3306/DB이름
   export DB_USER=유저명
   export DB_PASSWORD=비밀번호
   ```

2. **애플리케이션 실행**
   ```bash
   java -jar kjy_test_backend-0.0.1-SNAPSHOT.jar
   ```

3. **Swagger UI 확인**  
   실행 후, 브라우저에서 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) 에 접속하여 API 문서를 확인할 수 있습니다.

## 데이터베이스 설정

- MariaDB를 사용하며, 데이터베이스 연결 정보는 `application.yml` 파일 내에서 환경 변수로 지정되어 있습니다.
- JPA는 `hibernate.ddl-auto`를 `update`로 설정하여, 애플리케이션 시작 시 스키마를 자동 업데이트 합니다.

## API 엔드포인트

- `POST /board/register` : 새 게시글 등록
- `GET /board/list?page={page}&size={size}` : 게시글 목록 조회 (페이징 처리)
- `GET /board/{boardIdx}` : 게시글 상세 조회
- `POST /board/{boardIdx}/register` : 댓글 등록

## 프로젝트 구조

```
kjy_test_backend
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.kjy_test_backend
│   │   │       ├── board
│   │   │       │   ├── BoardController.java
│   │   │       │   ├── BoardService.java
│   │   │       │   ├── BoardRepository.java
│   │   │       │   ├── CommentRepository.java
│   │   │       │   └── model
│   │   │       │       ├── Board.java
│   │   │       │       ├── BoardDto.java
│   │   │       │       ├── Comment.java
│   │   │       │       └── CommentDto.java
│   │   └── resources
│   │       └── application.yml
└── pom.xml
```

## 참고 사항

- 추가 API 문서는 Swagger UI에서 확인 가능합니다.
- 페이징 처리는 Spring Data JPA의 `PageRequest`를 사용하며, API 응답에는 `boards` 리스트와 `totalPages` 정보가 포함됩니다.
