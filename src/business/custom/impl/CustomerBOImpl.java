/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.SuperDAO;
import dao.custom.CustomerDAO;
import dao.custom.QueryDAO;
import dto.CustomDTO;
import dto.CustomerDTO;
import entity.CustomEntity;
import entity.Customer;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sanu
 */
public class CustomerBOImpl implements CustomerBO{

    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);
    QueryDAO qdo = (QueryDAO) DAOFactory.getInstance().getDAO(DAOTypes.QUERY);    
    

    public boolean addCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException {
        return dao.add(new Customer(c.getId(), c.getName(), c.getAddress(), c.getSalary()));
    }

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        return dao.delete(id);
    }

    public boolean updateCustomer(CustomerDTO c) throws SQLException, ClassNotFoundException {
        return dao.update(new Customer(c.getId(), c.getName(), c.getAddress(), c.getSalary()));
    }

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer c = dao.search(id);
        return new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary());
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException {
        ArrayList<Customer> all = dao.getAll();
        ArrayList<CustomerDTO> allCus = new ArrayList();
        for (Customer c : all) {
            allCus.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary()));
        }
        return allCus;
    }

    @Override
    public ArrayList<CustomDTO> getAllCustomerItemDetails() throws Exception {
        ArrayList<CustomEntity> allCustomerItemDetails = qdo.getAllCustomerItemDetails();
        ArrayList<CustomDTO> allCustomDetails= new ArrayList();
        for (CustomEntity a : allCustomerItemDetails) {
            allCustomDetails.add(new CustomDTO(a.getName(), a.getCode(), a.getDescription(), a.getUnitPrice()));
        }
        return allCustomDetails;
    }
}
