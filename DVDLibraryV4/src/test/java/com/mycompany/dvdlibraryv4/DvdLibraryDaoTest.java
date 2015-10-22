


package com.mycompany.dvdlibraryv4;

import com.mycompany.dvdlibraryv4.dao.DvdLibraryDao;
import com.mycompany.dvdlibraryv4.dao.SearchTerm;
import com.mycompany.dvdlibraryv4.model.DVD;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.TestCase.assertNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DvdLibraryDaoTest {

    private DvdLibraryDao dao;

    public DvdLibraryDaoTest() {
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
        dao = ctx.getBean("dvdLibraryDao", DvdLibraryDao.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteDVD() {
// create new DVD
        DVD nc = new DVD();
        nc.setTitle("John");
        nc.setReleaseDate("2015");
        nc.setMpaaRating("R");
        nc.setDirector("John Doe");
        nc.setStudio("Orlando");
        nc.setNote("lots of stuff");
        dao.addDVD(nc);
        DVD fromDb = dao.getDVDById(nc.getId());
        assertEquals(fromDb, nc);
        dao.removeDVD(nc.getId());
        assertNull(dao.getDVDById(nc.getId()));
    }

    @Test
    public void addUpdateDVD() {
// create new DVD
        DVD nc = new DVD();
        nc.setTitle("John");
        nc.setReleaseDate("2014");
        nc.setMpaaRating("R");
        nc.setDirector("John Doe");
        nc.setStudio("Orlando");
        nc.setNote("lots of stuff");
        dao.addDVD(nc);
        nc.setNote("9999999999");
        dao.updateDVD(nc);
        DVD fromDb = dao.getDVDById(nc.getId());
        assertEquals(fromDb, nc);
    }

    @Test
    public void getAllDVDs() {
// create new DVD
        DVD nc = new DVD();
        nc.setTitle("John");
        nc.setReleaseDate("2014");
        nc.setMpaaRating("R");
        nc.setDirector("John Doe");
        nc.setStudio("Orlando");
        nc.setNote("lots of stuff");
        dao.addDVD(nc);
// create new DVD
        DVD nc2 = new DVD();
        nc2.setTitle("John");
        nc2.setReleaseDate("2014");
        nc2.setMpaaRating("R");
        nc2.setDirector("John Doe");
        nc2.setStudio("Orlando");
        nc2.setNote("lots of stuff");
        dao.addDVD(nc2);
        List<DVD> cList = dao.getAllDVDs();
        assertEquals(cList.size(), 2);
    }

    @Test
    public void searchDVDs() {
// create new DVD
        DVD nc = new DVD();
        nc.setTitle("John");
        nc.setReleaseDate("2014");
        nc.setMpaaRating("R");
        nc.setDirector("John Doe");
        nc.setStudio("Orlando");
        nc.setNote("lots of stuff");
        dao.addDVD(nc);
// create new DVD
        DVD nc2 = new DVD();
        nc2.setTitle("John");
        nc2.setReleaseDate("2014");
        nc2.setMpaaRating("G");
        nc2.setDirector("Johny Doe");
        nc2.setStudio("Microsoft");
        nc2.setNote("lots of stuff");
        dao.addDVD(nc2);
// create new DVD - same last name as first DVD but different
// title
        DVD nc3 = new DVD();
        nc3.setTitle("fJohn");
        nc3.setReleaseDate("2014");
        nc3.setMpaaRating("PG");
        nc3.setDirector("Johnoe");
        nc3.setStudio("Orlando2");
        nc3.setNote("lots of stuff");
        dao.addDVD(nc3);
// Create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.TITLE, "John");
        List<DVD> cList = dao.searchDVDs(criteria);
        assertEquals(2, cList.size());
        assertEquals(nc2, cList.get(1));
// New search criteria - look for Smith
        criteria.put(SearchTerm.TITLE, "John");
        cList = dao.searchDVDs(criteria);
        assertEquals(2, cList.size());
// Add company to search criteria
        criteria.put(SearchTerm.STUDIO, "Orlando");
        cList = dao.searchDVDs(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc, cList.get(0));
// Change company to Microsoft, should get back nc3
        criteria.put(SearchTerm.STUDIO, "Microsoft");
        cList = dao.searchDVDs(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc2, cList.get(0));
// Change company to Apple, should get back nothing
        criteria.put(SearchTerm.STUDIO, "Apple");
        cList = dao.searchDVDs(criteria);
        assertEquals(0, cList.size());
    }
}
