package com.example.manageemployee.dao;


import com.example.manageemployee.database.ConnectionUtil;
import com.example.manageemployee.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    Connection connection = ConnectionUtil.getConnection();

    public List<Employee> getEmployee(){
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Employee employee = new Employee();
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                list.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Employee> getEmployeeById(int id){
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Employee employee = new Employee();
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                list.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public String insertEmployee(Employee employee){
        String sql = "INSERT INTO employees" + "  (name, email, address, phone) VALUES " +
                " (?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getAddress());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getPhone());
            int isSuccess = ps.executeUpdate();
            if (isSuccess > 0 ){
                return "Success";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "Fail";
    }

    public String updateEmployee(Employee employee){
        String sql = "UPDATE employees SET name = ?,email= ?, address = ?, phone = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getPhone());
            int isSuccess = ps.executeUpdate();
            if (isSuccess > 0){
                return  "Success";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "Fail";
    }

    public boolean deleteEmployeeById(int id){
        boolean rowDeleted;
        String sql = "DELETE FROM WHERE id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    public String deleteEmployee(){
        String sql = "DELETE FROM employees";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            int isSuccess = ps.executeUpdate();

            if (isSuccess > 0){
                return "Success";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "Fail";
    }

}
