/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Operation.Customer;
import Operation.Florable;
import Operation.Wood;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AccessTest {
    
    public AccessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readTaxes method, of class Access.
     */
    @Test
    public void testReadTaxes() {
        System.out.println("readTaxes");
        String filename = "states";
        Access instance = new Access();
        HashMap<String, Double> expResult = new HashMap();
        expResult.put("OH",6.25);
        expResult.put("PA",6.75);
        expResult.put("MI",5.75);
        expResult.put("IN",6.00);
        HashMap<String, Double> result = instance.readTaxes(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readCost method, of class Access.
     */
    @Test
    public void testReadCost() {
        System.out.println("readCost");
        String filename = "products";
        Access instance = new Access();
        ArrayList<String> expResult = new ArrayList();
        expResult.add("Carpet");
        expResult.add("2.25");
        expResult.add("2.10");
        expResult.add("Laminate");
        expResult.add("1.75");
        expResult.add("2.10");
        expResult.add("Tile");
        expResult.add("3.50");
        expResult.add("4.15");
        expResult.add("Wood");
        expResult.add("5.15");
        expResult.add("4.75");
        ArrayList<String> result = instance.readCost(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeOrder method, of class Access.
     */
    //We are testing writing a file and then reading that file in the next test.
    @Test
    public void testWriteOrder() {
        System.out.println("writeOrder");
        String filename = "TestWriteOrder";
        Wood test = new Wood("Wood", 2.0, 2.0, 100);
        HashMap<String, Florable> r = new HashMap();
        r.put("123", test);
        Customer charlie = new Customer("Charlie", "Brown", "PA", 5.5, r);
        ArrayList<Customer> orderBook = new ArrayList();
        orderBook.add(charlie);
        Access instance = new Access();
        instance.writeOrder(filename, orderBook);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of readOrder method, of class Access.
     */
    @Test
    public void testReadOrder() {
        System.out.println("readOrder");
        String filename = "TestWriteOrder";
        Access instance = new Access();
        ArrayList<String> expResult = new ArrayList();
        expResult.add("Charlie::Brown::PA::5.5::123::Wood::100.0::2.0::2.0::200.0::200.0::11.0::411.0");
        ArrayList<String> result = instance.readOrder(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}