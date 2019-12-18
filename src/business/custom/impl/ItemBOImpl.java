/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom.impl;

import business.custom.ItemBO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sanu
 */
public class ItemBOImpl implements ItemBO{

    ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOTypes.ITEM);

    public boolean addItem(ItemDTO i) throws ClassNotFoundException, SQLException {
        return dao.add(new Item(i.getCode(), i.getItemName(), i.getQtyOnHand(), i.getUnitPrice()));
    }

    public boolean deleteItem(String id) throws ClassNotFoundException, SQLException {
        return dao.delete(id);
    }

    public boolean updateItem(ItemDTO i) throws ClassNotFoundException, SQLException {
        return dao.update(new Item(i.getCode(), i.getItemName(), i.getQtyOnHand(), i.getUnitPrice()));
    }

    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException {
        Item i = dao.search(id);
        return new ItemDTO(i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice());
    }

    public ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException {
        ArrayList<Item> all = dao.getAll();
        ArrayList<ItemDTO> allItems = new ArrayList();
        for (Item i : all) {
            allItems.add(new ItemDTO(i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice()));
        }
        return allItems;
    }
}
