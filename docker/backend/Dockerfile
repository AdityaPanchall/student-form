FROM tomcat:10.1-jdk17-temurin

# Remove default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the application WAR
COPY target/form.war /usr/local/tomcat/webapps/form.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
