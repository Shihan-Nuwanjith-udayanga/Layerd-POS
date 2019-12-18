/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.BOFactory;
import business.BOTypes;
import business.custom.ItemBO;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.ItemDTO;

/**
 *
 * @author sanu
 */
public class ItemController {

//    ItemBO itemBO = new ItemBOImpl();
    ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOTypes.ITEM);

    public ItemController() {

    }

    public boolean addItem(ItemDTO i) throws ClassNotFoundException, SQLException {
        return itemBO.addItem(i);
    }

    public boolean deleteItem(String id) throws ClassNotFoundException, SQLException {
        return itemBO.deleteItem(id);
    }

    public boolean updateItem(ItemDTO i) throws ClassNotFoundException, SQLException {
        return itemBO.updateItem(i);
    }

    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException {
        return itemBO.searchItem(id);
    }

    public ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException {
        return itemBO.getAllItems();
    }
}
