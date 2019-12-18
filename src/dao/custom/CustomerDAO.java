/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom;

import entity.Customer;
import dao.CrudDAO;

/**
 *
 * @author sanu
 */
public interface CustomerDAO extends CrudDAO<Customer, String> {

    public String getCustomerMaxID() throws Exception;
}
