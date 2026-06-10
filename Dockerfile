# ===============================
# 1단계: Spring Boot 프로젝트를 jar 파일로 빌드하는 단계
# ===============================

# Java 17 + Gradle이 들어있는 이미지
FROM gradle:8.14.3-jdk17 AS builder

# 컨테이너 안에서 작업할 폴더 지정
WORKDIR /app

# Gradle 설정 파일 복사
COPY settings.gradle build.gradle ./

# Gradle Wrapper 파일 복사
COPY gradle ./gradle
COPY gradlew ./gradlew

# 실제 소스 코드 복사
COPY src ./src

# Spring Boot 실행 jar 생성
# -x test는 Docker 이미지 만들 때 테스트를 건너뛰겠다는 뜻
RUN chmod +x ./gradlew && ./gradlew clean bootJar -x test


# ===============================
# 2단계: 만들어진 jar 파일을 실행하는 단계
# ===============================

# 실제 존재하는 Java 17 실행 이미지
# eclipse-temurin은 Eclipse IDE가 아니라 Java 실행 이미지 이름임
FROM eclipse-temurin:17-jre-alpine

# 컨테이너 안에서 작업할 폴더 지정
WORKDIR /app

# builder 단계에서 만든 jar 파일을 app.jar 이름으로 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# Spring Boot 기본 포트
EXPOSE 8080

# 컨테이너 시작 시 Spring Boot 앱 실행
ENTRYPOINT ["java", "-jar", "app.jar"]