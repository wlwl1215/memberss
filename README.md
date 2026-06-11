# API 명세서

## 공통 정보
- 환경: local
- Domain: http://localhost:8080
- 기본 API 경로: /api/members
- Content-Type: application/json

| 항목           | 내용                    |
| ------------ | --------------------- |
| 환경           | Local                 |
| Domain       | http://localhost:8080 |
| 기본 API 경로    | /api/members          |
| Content-Type | application/json      |

---

## 회원 API

### 회원등록

[API 용도]

새로운 회원 정보를 등록한다.

[Request]

* Method: POST
* Path: /api/members
* Content-Type: application/json

[Request Body]

| Name  | Type   | Required | Description |
| ----- | ------ | -------- | ----------- |
| name  | String | O        | 회원 이름       |
| email | String | O        | 회원 이메일      |

[Request Example]

```http
POST /api/members HTTP/1.1
Content-Type: application/json
Host: localhost:8080

{
  "name": "홍길동",
  "email": "hong@example.com"
}
```

[Response Example]

```json
{
  "id": 1,
  "name": "홍길동",
  "email": "hong@example.com"
}
```

---

### 회원조회

[API 용도]

회원 ID를 기준으로 회원 1명의 정보를 조회한다.

[Request]

* Method: GET
* Path: /api/members/{id}

[Path Variable]

| Name | Type   | Required | Description |
| ---- | ------ | -------- | ----------- |
| id   | Number | O        | 조회할 회원 ID   |

[Request Example]

```http
GET /api/members/1 HTTP/1.1
Host: localhost:8080
```

[Response Example]

```json
{
  "id": 1,
  "name": "홍길동",
  "email": "hong@example.com"
}
```

---

### 전체 회원조회

[API 용도]

등록된 전체 회원 목록을 조회한다.

[Request]

* Method: GET
* Path: /api/members

[Request Example]

```http
GET /api/members HTTP/1.1
Host: localhost:8080
```

[Response Example]

```json
[
  {
    "id": 1,
    "name": "홍길동",
    "email": "hong@example.com"
  },
  {
    "id": 2,
    "name": "김철수",
    "email": "kim@example.com"
  }
]
```

---

### 회원수정

[API 용도]

기존 회원 정보를 수정한다.

[Request]

* Method: PUT
* Path: /api/members
* Content-Type: application/json

[Request Body]

| Name  | Type   | Required | Description |
| ----- | ------ | -------- | ----------- |
| id    | Number | O        | 수정할 회원 ID   |
| name  | String | O        | 수정할 회원 이름   |
| email | String | O        | 수정할 회원 이메일  |

[Request Example]

```http
PUT /api/members HTTP/1.1
Content-Type: application/json
Host: localhost:8080

{
  "id": 1,
  "name": "홍길동 수정",
  "email": "hong_update@example.com"
}
```

[Response Example]

```json
{
  "id": 1,
  "name": "홍길동 수정",
  "email": "hong_update@example.com"
}
```

---

### 회원삭제

[API 용도]

회원 ID를 기준으로 회원 정보를 삭제한다.

[Request]

* Method: DELETE
* Path: /api/members/{id}

[Path Variable]

| Name | Type   | Required | Description |
| ---- | ------ | -------- | ----------- |
| id   | Number | O        | 삭제할 회원 ID   |

[Request Example]

```http
DELETE /api/members/1 HTTP/1.1
Host: localhost:8080
```

[Response Example]

```json
{
  "message": "회원 삭제 완료"
}
```

---

### API 경로 요약

[Endpoint List]

| API     | Method | Path              | Description                  |
| ------- | ------ | ----------------- | ---------------------------- |
| 회원등록    | POST   | /api/members      | 새로운 회원 정보를 등록한다.             |
| 회원조회    | GET    | /api/members/{id} | 회원 ID를 기준으로 회원 1명의 정보를 조회한다. |
| 전체 회원조회 | GET    | /api/members      | 등록된 전체 회원 목록을 조회한다.          |
| 회원수정    | PUT    | /api/members      | 기존 회원 정보를 수정한다.              |
| 회원삭제    | DELETE | /api/members/{id} | 회원 ID를 기준으로 회원 정보를 삭제한다.     |
