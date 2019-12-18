/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Customer;

/**
 *
 * @author sanu
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer c) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("INSERT INTO Customer VALUES(?,?,?,?)",
                c.getId(), c.getName(), c.getAddress(), c.getSalary());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public boolean update(Customer c) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Customer SET id=?,name=?,address=?,salary=? WHERE id=?", c.getId(), c.getName(), c.getAddress(), c.getSalary());
    }

    @Override
    public Customer search(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE id=?", id);
        if (rst.next()) {
            return new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
        }
        return null;

    }

    @Override
    public ArrayList<Customer> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()) {
            allCustomers.add(
                    new Customer(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getDouble(4)
                    )
            );
        }
        return allCustomers;
    }

    @Override
    public String getCustomerMaxID() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT max(id) from Customer");
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
}
