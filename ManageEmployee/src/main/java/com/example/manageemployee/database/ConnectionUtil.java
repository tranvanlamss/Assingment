package com.example.manageemployee.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection;

    public static synchronized Connection getConnection(){
        String url  = "jdbc:mysql://3306/employees";
        String user = "root";
        String password = "root";
        if (connection == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            }catch (SQLException | ClassNotFoundException throwables){
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            connection = null;
        }
    }
}
