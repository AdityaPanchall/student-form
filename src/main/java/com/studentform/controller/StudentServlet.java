package com.studentform.controller;

import com.studentform.model.Student;
import com.studentform.repository.JdbcStudentRepository;
import com.studentform.repository.StudentRepository;
import com.studentform.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/form")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() {

        StudentRepository repository =
                new JdbcStudentRepository();

        studentService =
                new StudentService(repository);
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/index.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String firstName =
                    request.getParameter("firstName");

            String lastName =
                    request.getParameter("lastName");

            String dob =
                    request.getParameter("dob");

            String gender =
                    request.getParameter("gender");

            String qualification =
                    request.getParameter(
                            "highestqualification"
                    );

            String year =
                    request.getParameter(
                            "year_of_passing"
                    );

            String mobile =
                    request.getParameter(
                            "mobilenumber"
                    );

            Student student = new Student(
                    firstName,
                    lastName,
                    LocalDate.parse(dob),
                    gender,
                    qualification,
                    Integer.parseInt(year),
                    mobile
            );

            studentService.registerStudent(student);

            response.sendRedirect(
                    request.getContextPath()
                            + "/form?status=success"
            );

        } catch (Exception e) {

            response.sendRedirect(
                    request.getContextPath()
                            + "/form?status=error"
            );
        }
    }
}