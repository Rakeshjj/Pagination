FROM openjdk:21-jdk

COPY target/Pagination.jar .

EXPOSE 8080

ENTRYPOINT [ "java","-jar","Pagination.jar" ]