


package com.mycompany.addressbookv4.controller;

import com.mycompany.addressbookv4.dao.AddressBook;
import com.mycompany.addressbookv4.dao.SearchTerm;
import com.mycompany.addressbookv4.model.Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {
    private AddressBook dao;
    @Inject
    public SearchController(AddressBook dao) {
        this.dao = dao;
    }
    @RequestMapping(value={"/search"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "search";
    }
    
    @RequestMapping(value = "search/addresss", method = RequestMethod.POST)
    @ResponseBody

    public List<Address> searchContacts(@RequestBody Map<String, String> searchMap) {
// Create the map of search criteria to send to the DAO
        Map<SearchTerm, String> criteriaMap = new HashMap<>();
// Determine which search terms have values, translate the String
// keys into SearchTerm enums, and set the corresponding values
// appropriately.
        String currentTerm = searchMap.get("fName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.FIRST_NAME, currentTerm);
        }
        currentTerm = searchMap.get("lName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.LAST_NAME, currentTerm);
        }
        currentTerm = searchMap.get("street");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STREET, currentTerm);
        }
        currentTerm = searchMap.get("city");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.CITY, currentTerm);
        }
        currentTerm = searchMap.get("state");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STATE, currentTerm);
        }
        
        currentTerm = searchMap.get("zip");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.ZIP, currentTerm);
        }
        return dao.searchAddresss(criteriaMap);
    }
    
    
}
