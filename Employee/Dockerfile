FROM java:8
VOLUME /tmp
ADD target/Employee-0.0.1-SNAPSHOT.jar Employee.jar
RUN bash -c 'touch /Employee.jar'
EXPOSE 8081
ENTRYPOINT ["java","-jar","/Employee.jar"]