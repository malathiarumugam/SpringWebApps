/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

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
public class LaminateTest {
    
    public LaminateTest() {
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
     * Test of getMaterialCost method, of class Laminate.
     */
    @Test
    public void testGetMaterialCost() {
        System.out.println("getMaterialCost");
       Laminate instance = new Laminate("wood", 2.5, 2.5, 200);
        double expResult = 500.0;
        double result = instance.getMaterialCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLaborCost method, of class Laminate.
     */
    @Test
    public void testGetLaborCost() {
        System.out.println("getLaborCost");
        Laminate instance = new Laminate("wood", 2.5, 2.5, 200);
        double expResult = 500.0;
        double result = instance.getLaborCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTax method, of class Laminate.
     */
    @Test
    public void testGetTax() {
        System.out.println("getTax");
        double taxRate = 1.0;
        Laminate instance = new Laminate("wood", 2.5, 2.5, 200);
        double expResult = 5.0;
        double result = instance.getTax(taxRate);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Laminate.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        double tax = 1.0;
        Laminate instance = new Laminate("wood", 2.5, 2.5, 200);
        double expResult = 1005.0;
        double result = instance.getTotal(tax);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
