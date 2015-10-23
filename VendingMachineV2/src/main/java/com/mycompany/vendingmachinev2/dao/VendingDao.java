/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachinev2.dao;

import com.mycompany.vendingmachinev2.model.Item;
import java.util.List;


/**
 *
 * @author apprentice
 */
public interface VendingDao {
    
    public Item findItemByCode(String itemCode);

    public void lowerItemCount(Item name);

    public void removeItem(String code);
    
    public int returnItemInventory(Item name);
    
    public void addItem(Item item);
    
    public List<Item> getAllItems();
    
}
