/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.BOFactory;
import business.BOTypes;
import business.SuperBO;
import business.custom.CustomerBO;
import business.custom.impl.CustomerBOImpl;
import dto.CustomDTO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sanu
 */
public class CustomerController {

    CustomerBO bo = (CustomerBO) BOFactory.getInstance().getBO(BOTypes.CUSTOMER);

    public CustomerController() {

    }

    public boolean addCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException {
        return bo.addCustomer(c);
    }

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        return bo.deleteCustomer(id);
    }

    public boolean updateCustomer(CustomerDTO c) throws SQLException, ClassNotFoundException {
        return bo.updateCustomer(c);
    }

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo.searchCustomer(id);
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException {
        return bo.getAllCustomers();
    }

    public ArrayList<CustomDTO> getAllCustomerItemDetails() throws Exception {
        return bo.getAllCustomerItemDetails();

    }
}
