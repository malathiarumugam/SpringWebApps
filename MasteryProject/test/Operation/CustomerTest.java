/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class CustomerTest {

    public CustomerTest() {
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
     * Test of addOrder method, of class Customer.
     */
    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();
        Wood test = new Wood("Wood", 2.0, 2.0, 100);
        HashMap<String, Florable> r = new HashMap();
        Customer charlie = new Customer("Charlie", "Brown", "PA", 5.5, r);
        Customer instance = new Customer();
        String expResult = dateFormat.format(cal.getTime());
        String result = instance.addOrder(charlie, test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrder method, of class Customer.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("removeOrder");
        Wood test = new Wood("Wood", 2.0, 2.0, 100);
        HashMap<String, Florable> r = new HashMap();
        r.put("123", test);
        Customer charlie = new Customer("Charlie", "Brown", "PA", 5.5, r);
        String orderNum = "123";
        HashMap<String, Florable> orderList = r;
        Customer instance = charlie;
        instance.removeOrder(orderNum, orderList);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Wood test = new Wood("Tile", 3.4, 4.15, 250);
        HashMap<String, Florable> r = new HashMap();
        r.put("20150924151207", test);
        Customer charlie = new Customer("John", "Smith", "OH", 6.25, r);
        String orderNum = "20150924151207";
        Customer instance = charlie;
        String expResult = "John Smith  Order Number: 20150924151207  Date: 2015/09/24\n"
                + "   Flooring: Tile   Area: 250.0   Total Cost: $1940.62\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of displayOrder method, of class Customer.
     */
    @Test
    public void testDisplayOrder_3args() {
        System.out.println("displayOrder");
        Wood test = new Wood("Tile", 3.4, 4.15, 250);
        HashMap<String, Florable> r = new HashMap();
        r.put("20150924151207", test);
        Customer charlie = new Customer("John", "Smith", "OH", 6.25, r);
        String orderNum = "20150924151207";
        Customer customer = charlie;
        HashMap<String, Florable> list = r;
        Customer instance = new Customer();
        String expResult = "John Smith  Order Number: 20150924151207  Date: 2015/09/24\n"
                + "   Flooring: Tile   Area: 250.0   Total Cost: $1940.62\n";
        String result = instance.displayOrder(customer, list, orderNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of displayOrder method, of class Customer.
     */
    @Test
    public void testDisplayOrder_String_ArrayList() {
        System.out.println("displayOrder");
        Wood test = new Wood("Tile", 3.4, 4.15, 250);
        HashMap<String, Florable> r = new HashMap();
        r.put("20150924151207", test);
        Customer charlie = new Customer("John", "Smith", "OH", 6.25, r);
        String orderNum = "20150924151207";
        ArrayList<Customer> orderBook = new ArrayList();
        orderBook.add(charlie);
        Customer instance = charlie;
        String expResult = "John Smith  Order Number: 20150924151207  Date: 2015/09/24\n"
                + "   Flooring: Tile   Area: 250.0   Total Cost: $1940.62\n";
        String result = instance.displayOrder(orderNum, orderBook);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of doAFlip method, of class Customer.
     */
    /*@Test
     public void testDoAFlip() {
     System.out.println("doAFlip");
     Customer instance = new Customer();
     instance.doAFlip();
     // TODO review the generated test code and remove the default call to fail.
     fail("The test case is a prototype.");
     }*/
}
