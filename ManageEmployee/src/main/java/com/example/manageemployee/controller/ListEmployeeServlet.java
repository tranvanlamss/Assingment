package com.example.manageemployee.controller;

import com.example.manageemployee.dao.EmployeeDAO;
import com.example.manageemployee.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListEmployeeServlet", value = "/employee-list")
public class ListEmployeeServlet extends HttpServlet {
    EmployeeDAO dao = new EmployeeDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("employees", getListEmployee());
        request.getRequestDispatcher("employee-list.jsp").forward(request, response);
    }

   protected List<Employee> getListEmployee(){
        List<Employee> list = dao.getEmployee();
        return list;
   }
}
