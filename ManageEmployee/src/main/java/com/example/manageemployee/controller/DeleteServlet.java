package com.example.manageemployee.controller;

import com.example.manageemployee.dao.EmployeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer map = Integer.valueOf(request.getParameter("id"));
        EmployeeDAO dao = new EmployeeDAO();
        try {
            if (dao.deleteEmployeeById(map)) {
                response.sendRedirect("employee-list.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
