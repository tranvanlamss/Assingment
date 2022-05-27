package com.example.manageemployee.controller;

import com.example.manageemployee.dao.EmployeeDAO;
import com.example.manageemployee.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertServlet", value = "/create")
public class InsertServlet extends HttpServlet {
    EmployeeDAO dao = new EmployeeDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPhone(phone);

        dao.insertEmployee(employee);
        response.sendRedirect("/list-employee");
    }
}
