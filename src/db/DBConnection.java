/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sanu
 */
public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade", "root", "nuwanjith");
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        return (dbConnection == null) ? (dbConnection = new DBConnection()) : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
