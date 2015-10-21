package com.mycompany.addressbookv4;



import com.mycompany.addressbookv4.dao.AddressBook;
import com.mycompany.addressbookv4.dao.SearchTerm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.mycompany.addressbookv4.model.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertNull;

public class AddressListDaoTest {

    private AddressBook dao;

    public AddressListDaoTest() {
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
        dao = ctx.getBean("addressBookDao", AddressBook.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteAddress() {
// create new address
        Address nc = new Address();
        nc.setfName("John");
        nc.setlName("Doe");
        nc.setStreet("Oracle");
        nc.setCity("john@doe.com");
        nc.setState("1234445678");
        nc.setZip("1234445678");
        dao.addAddress(nc);
        Address fromDb = dao.getAddressById(nc.getAddressId());
        assertEquals(fromDb, nc);
        dao.removeAddress(nc.getAddressId());
        assertNull(dao.getAddressById(nc.getAddressId()));
    }

    @Test
    public void addUpdateAddress() {
        // create new address
        Address nc = new Address();
        nc.setfName("Jimmy");
        nc.setlName("Smith");
        nc.setStreet("Sun");
        nc.setCity("jimmy@smith.com");
        nc.setZip("1234445678");
        nc.setState("1112223333");
        dao.addAddress(nc);
        nc.setState("9999999999");
        dao.updateAddress(nc);
        Address fromDb = dao.getAddressById(nc.getAddressId());
        assertEquals(fromDb, nc);
    }

    @Test
    public void getAllAddresss() {
// create new address
        Address nc = new Address();
        nc.setfName("Jimmy");
        nc.setlName("Smith");
        nc.setStreet("Sun");
        nc.setCity("jimmy@smith.com");
        nc.setState("1112223333");
        nc.setZip("1234445678");
        dao.addAddress(nc);
// create new address
        Address nc2 = new Address();
        nc2.setfName("John");
        nc2.setlName("Jones");
        nc2.setStreet("Apple");
        nc2.setCity("john@jones.com");
        nc2.setState("5556667777");
        nc.setZip("1234445678");
        dao.addAddress(nc2);
        List<Address> cList = dao.getAllAddresss();
        assertEquals(cList.size(), 2);
    }

    @Test
    public void searchAddresss() {
// create new address
        Address nc = new Address();
        nc.setfName("Jimmy");
        nc.setlName("Smith");
        nc.setStreet("Sun");
        nc.setCity("jimmy@smith.com");
        nc.setState("1112223333");
        nc.setZip("1234445678");
        dao.addAddress(nc);
// create new address
        Address nc2 = new Address();
        nc2.setfName("John");
        nc2.setlName("Jacob");
        nc2.setStreet("Apple");
        nc2.setCity("john@jones.com");
        nc2.setState("5556667777");
        nc.setZip("1234445678");
        dao.addAddress(nc2);
// create new address - same last name as first address but different
// company
        Address nc3 = new Address();
        nc3.setfName("Steve");
        nc3.setlName("Smith");
        nc3.setStreet("Microsoft");
        nc3.setCity("steve@msft.com");
        nc3.setState("5552221234");
        dao.addAddress(nc3);
// Create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.LAST_NAME, "Smith");
        List<Address> cList = dao.searchAddresss(criteria);
        assertEquals(2, cList.size());
        assertEquals(nc, cList.get(0));
// New search criteria - look for Smith
        criteria.put(SearchTerm.LAST_NAME, "Smith");
        cList = dao.searchAddresss(criteria);
        assertEquals(2, cList.size());
// Add company to search criteria
        criteria.put(SearchTerm.STREET, "Sun");
        cList = dao.searchAddresss(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc, cList.get(0));
// Change company to Microsoft, should get back nc3
        criteria.put(SearchTerm.STREET, "Microsoft");
        cList = dao.searchAddresss(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc3, cList.get(0));
// Change company to Apple, should get back nothing
        criteria.put(SearchTerm.STREET, "Apple");
        cList = dao.searchAddresss(criteria);
        assertEquals(0, cList.size());
    }
}
