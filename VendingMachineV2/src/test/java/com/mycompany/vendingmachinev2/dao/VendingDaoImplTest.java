/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachinev2.dao;

import com.mycompany.vendingmachinev2.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class VendingDaoImplTest {
    
    private VendingDao dao;
    
    public VendingDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
dao = (VendingDao) ctx.getBean("VendingDao");
// Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from items");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findItemByCode method, of class VendingDaoImpl.
     */
    @Test
    public void testFindItemByCode() {
        System.out.println("findItemByCode");
        String itemCode = "A1";
        VendingDaoImpl instance = new VendingDaoImpl();
        Item expResult = new Item("Snickers", new BigDecimal(1.00), 10, "A1");
        instance.addItem(expResult);
        Item result = instance.findItemByCode(itemCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of lowerItemCount method, of class VendingDaoImpl.
     */
    @Test
    public void testLowerItemCount() {
        System.out.println("lowerItemCount");
        VendingDaoImpl instance = new VendingDaoImpl();
        Item expResult = new Item("Snickers", new BigDecimal(1.00), 10, "A1");
        instance.addItem(expResult);
        instance.lowerItemCount(expResult.getCode());
        assertEquals(9, instance.findItemByCode("A1").getCount());
    }

    /**
     * Test of removeItem method, of class VendingDaoImpl.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        String code = "A1";
        Item item = new Item("Snickers", new BigDecimal(1.00), 10, "A1");
        VendingDaoImpl instance = new VendingDaoImpl();
        instance.addItem(item);
        instance.removeItem(code);
        assertEquals(0, instance.getItemMap().size());
    }

    /**
     * Test of returnItemInventory method, of class VendingDaoImpl.
     */
    @Test
    public void testReturnItemInventory() {
        System.out.println("returnItemInventory");
        Item item = new Item("Snickers", new BigDecimal(1.00), 10, "A1");
        VendingDaoImpl instance = new VendingDaoImpl();
        instance.addItem(item);
        int expResult = 10;
        int result = instance.returnItemInventory(item);
        assertEquals(expResult, result);
    }

    /**
     * Test of addItem method, of class VendingDaoImpl.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Item item = new Item("Snickers", new BigDecimal(1.00), 10, "A1");
        VendingDaoImpl instance = new VendingDaoImpl();
        instance.addItem(item);
        assertEquals(1, instance.getItemMap().size());
    }

    /**
     * Test of getAllItems method, of class VendingDaoImpl.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        Item item = new Item("Snickers", new BigDecimal(1.00), 10, "A1");
        Item item2 = new Item("Snickersy", new BigDecimal(1.10), 11, "A2");
        VendingDaoImpl instance = new VendingDaoImpl();
        instance.addItem(item);
        instance.addItem(item2);
        List<Item> expResult = new ArrayList<Item>(instance.getItemMap().values());
        List<Item> result = instance.getAllItems();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateItem method, of class VendingDaoImpl.
     */
    @Test
    public void testUpdateItem() {
        System.out.println("updateItem");
        Item item = new Item("Snickers", new BigDecimal(1.00), 10, "A1");
        VendingDaoImpl instance = new VendingDaoImpl();
        instance.addItem(item);
        instance.updateItem(item);
    }
    
}
