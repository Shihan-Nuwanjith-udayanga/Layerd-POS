/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sanu
 */
public class CrudUtil {

    public static <T>T execute(String sql, Object... params) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1, params[i]);
        }
        
        if (sql.startsWith("SELECT")) {
           return (T) pstm.executeQuery();
        }
        
         return (T) ((Boolean)(pstm.executeUpdate()>0));
     

    }

//    public static boolean executeUpdate(String sql, Object... params) throws ClassNotFoundException, SQLException {
//        PreparedStatement pstm = execute(sql, params);
//        return pstm.executeUpdate() > 0;
//
//    }
//
//    public static ResultSet executeQuery(String sql, Object... params) throws ClassNotFoundException, SQLException {
//        PreparedStatement execute = execute(sql, params);
//        return execute.executeQuery();
//    }

}
