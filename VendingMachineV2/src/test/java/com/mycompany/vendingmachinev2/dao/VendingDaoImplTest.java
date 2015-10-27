/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachinev2.dao;

import com.mycompany.vendingmachinev2.model.Item;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        dao = ctx.getBean("vendingmachine", VendingDao.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findItemByCode method, of class VendingDaoImpl.
     */
//    @Test
//    public void testFindItemByCode() {
//        System.out.println("findItemByCode");
//        String itemCode = "";
//        VendingDaoImpl instance = new VendingDaoImpl();
//        Item expResult = null;
//        Item result = instance.findItemByCode(itemCode);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of lowerItemCount method, of class VendingDaoImpl.
//     */
//    @Test
//    public void testLowerItemCount() {
//        System.out.println("lowerItemCount");
//        Item name = null;
//        VendingDaoImpl instance = new VendingDaoImpl();
//        instance.lowerItemCount(name);
//    }
//
//    /**
//     * Test of removeItem method, of class VendingDaoImpl.
//     */
//    @Test
//    public void testRemoveItem() {
//        System.out.println("removeItem");
//        String code = "";
//        VendingDaoImpl instance = new VendingDaoImpl();
//        instance.removeItem(code);
//    }
//
//    /**
//     * Test of returnItemInventory method, of class VendingDaoImpl.
//     */
//    @Test
//    public void testReturnItemInventory() {
//        System.out.println("returnItemInventory");
//        Item name = null;
//        VendingDaoImpl instance = new VendingDaoImpl();
//        int expResult = 0;
//        int result = instance.returnItemInventory(name);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of addItem method, of class VendingDaoImpl.
//     */
//    @Test
//    public void testAddItem() {
//        System.out.println("addItem");
//        Item item = null;
//        VendingDaoImpl instance = new VendingDaoImpl();
//        instance.addItem(item);
//    }
//
//    /**
//     * Test of getAllItems method, of class VendingDaoImpl.
//     */
//    @Test
//    public void testGetAllItems() {
//        System.out.println("getAllItems");
//        VendingDaoImpl instance = new VendingDaoImpl();
//        List<Item> expResult = null;
//        List<Item> result = instance.getAllItems();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of updateItem method, of class VendingDaoImpl.
//     */
//    @Test
//    public void testUpdateItem() {
//        System.out.println("updateItem");
//        Item item = null;
//        VendingDaoImpl instance = new VendingDaoImpl();
//        instance.updateItem(item);
//    }
    
}
