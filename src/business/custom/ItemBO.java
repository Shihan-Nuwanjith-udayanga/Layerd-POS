/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom;

import business.SuperBO;
import dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sanu
 */
public interface ItemBO  extends SuperBO{
    public boolean addItem(ItemDTO i) throws ClassNotFoundException, SQLException ;
    public boolean deleteItem(String id) throws ClassNotFoundException, SQLException;
    public boolean updateItem(ItemDTO i) throws ClassNotFoundException, SQLException;
    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException ;
     public ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException;
}
