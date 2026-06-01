# memberss API Specification

## 1. 공통 설정 (Base Configuration)
* Local Environment: 'http://localhost:8080/api/members'
* content-Type: 'application/json'

---

## 2. 엔드포인트 목록 (Endpoints)
1) 회원등록 CREATE : 'POST', '/api/members'
2) 회원조회(1건) READ : 'GET', '/api/members/{id}'
3) 회원조회(전체) READ : 'GET', '/api/members'
4) 회원수정 UPDATE : 'PUT', '/api/members'
5) 회원삭제 DELETE : 'DELETE', /api/members/{id}' 