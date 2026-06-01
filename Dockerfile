# 1. 자바 17이 설치된 가벼운 리눅스 이미지를 기반으로 시작합니다.
FROM openjdk:17-jdk-slim

# 2. 컨테이너 내부에서 작업할 폴더 위치를 정합니다.
WORKDIR /app

# 3. 빌드된 스프링 부트의 진짜 알맹이(JAR 파일)를 컨테이너 안으로 복사합니다.
# gradle 빌드 시 파일이 빌드되는 경로입니다.
COPY build/libs/*-SNAPSHOT.jar app.jar

# 4. 컨테이너가 켜질 때 스프링 부트를 실행할 명령어를 지정합니다.
ENTRYPOINT ["java", "-jar", "app.jar"]