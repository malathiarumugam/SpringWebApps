


package com.mycompany.dvdlibraryv4.controller;


import com.mycompany.dvdlibraryv4.dao.DvdLibraryDao;
import com.mycompany.dvdlibraryv4.model.DVD;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AddController {
    
     private DvdLibraryDao dao;

    @Inject
    public AddController(DvdLibraryDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value={"/Add"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "Add";
    }
    
        @RequestMapping(value = "/dvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DVD createDvd(@Valid @RequestBody DVD dvd) {
        dao.addDVD(dvd);
        return dvd;
    }
    
    
}
