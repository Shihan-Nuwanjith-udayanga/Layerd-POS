/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.CustomEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanu
 */
public class QueryDAOImpl implements QueryDAO{

    @Override
    public ArrayList<CustomEntity> getAllCustomerItemDetails() throws SQLException {
        ArrayList<CustomEntity> allDetails = new ArrayList<CustomEntity>();
        try {
            ResultSet rst = CrudUtil.execute("SELECT * FROM Customer,Item");

            while (rst.next()) {
                String id = rst.getString(1);
                String name = rst.getString(2);
                String address = rst.getString(3);
                double salary = rst.getDouble(4);
                String code = rst.getString(5);
                String itemNam = rst.getString(6);
                int qty = rst.getInt(7);
                double unitPrice = rst.getDouble(8);

                CustomEntity customEntity = new CustomEntity(id, name, address, salary, code, itemNam, qty, unitPrice);
                allDetails.add(customEntity);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QueryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allDetails;

    }

 
}
