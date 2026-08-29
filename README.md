# Student Registration Portal

A Java-based Student Registration Portal built for practicing
application deployment and CI/CD.

## Technology Stack

- Java 17
- Jakarta Servlet
- JSP
- HTML5
- CSS3
- JavaScript
- Maven
- PostgreSQL
- Apache Tomcat
- GitLab
- Jenkins

---

## Application Architecture

Browser
    |
    v
JSP / HTML / CSS / JavaScript
    |
    v
StudentServlet
    |
    v
StudentService
    |
    v
StudentRepository
    |
    v
JdbcStudentRepository
    |
    v
PostgreSQL


---

## Student Fields

The application collects:

1. First Name
2. Last Name
3. Date of Birth
4. Gender
5. Highest Qualification
6. Year of Passing
7. Mobile Number

---

## Database

Database:

projectForm

Table:

formDetails

---

## Local Build

Run:

```bash
mvn clean test