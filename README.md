# Spring kafka example

учебный пример по Apache Kafka + Spring Boot

### Стэк технологий
- Java 11
- Spring Boot
- Spring Web
- Gradle
- Docker-compose

## Сборка и запуск приложения
```shell script
# Склонировать проект к себе
git clone https://github.com/devalurum/spring-kafka-example.git

# поднять контейнеры c Zookeeper и Kafka
docker-compose up -d

# загрузить gradle wrapper
gradlew wrapper

# сборка проекта
gradlew clean build 

# запуск Spring сервиса
java -jar build/libs/spring-kafka-example.jar 

# Отправка сообщения
curl -d "message=TestMessage" -X POST http://localhost:82/api/v1/kafka/publish
```

