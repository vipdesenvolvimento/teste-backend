FROM openjdk:11
ENV TZ="America/Sao_Paulo"
EXPOSE 8080
ADD target/backend-1.0 backend-1.0.jar
ENTRYPOINT ["java","-jar","/backend-1.0.jar"]