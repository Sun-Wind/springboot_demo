FROM openjdk:8u212-jdk
VOLUME /tmp
RUN mkdir -p /app
#ADD 后面的参数是项目名字 / 后面的参数是自定义的别名
ADD target/test.jar /school.jar
#这里的最后一个变量需要和前面起的别名相同
COPY target/test.jar /app/test.jar
COPY src/main/resources/logback.xml /app/logback.xml
COPY src/main/resources/application.yml /app/app.xml
WORKDIR /app
EXPOSE 9091
ENTRYPOINT ["java", "-Dlogback.configurationFile=/app/logback.xml","-jar", "/school.jar"]

