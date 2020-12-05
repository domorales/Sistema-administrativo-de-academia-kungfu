/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dilan
 */
public class ConectionMySQL {
    
    private static final String URL ="jdbc:mysql://localhost:3306/KUNGFUPANDA?useSSL=false";
    private static final String USERNAME="admin";
    private static final String PASSWORD ="1234";
    
    public static Connection getConection(){
        Connection conexion =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion =(Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }

   
}
