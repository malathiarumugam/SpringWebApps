


package com.mycompany.vendingmachinev2.dao;

import com.mycompany.vendingmachinev2.model.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VendingDaoImpl implements VendingDao {

    private Map<String, Item> itemMap = new HashMap<>();

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<String, Item> itemMap) {
        this.itemMap = itemMap;
    }
    
    @Override
    public Item findItemByCode(String itemCode) {
        for (Item a : itemMap.values()) {
            if (itemCode.equalsIgnoreCase(a.getCode())) {
               return a; 
            }
        }
        return null;
    }

    @Override
    public void lowerItemCount(String code) {
        Item item = findItemByCode(code);
        item.setCountOne();
    }

    @Override
    public void removeItem(String code) {
        itemMap.remove(code);
    }

    @Override
    public int returnItemInventory(Item name) {
        return name.getCount();
    }

    @Override
    public void addItem(Item item) {
        itemMap.put(item.getCode(), item);
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<Item>(itemMap.values());
        return list;
    }
    
    @Override
    public void updateItem(Item item) {
        itemMap.put(item.getCode(), item);
    }
    
    public List<Item> searchItems(Map<SearchTerm, String> criteria) {
        return new ArrayList<Item>();
    }

}
