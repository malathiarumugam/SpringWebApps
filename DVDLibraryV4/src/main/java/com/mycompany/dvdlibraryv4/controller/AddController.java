


package com.mycompany.dvdlibraryv4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddController {
    
    @RequestMapping(value={"/Add"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "Add";
    }
    
    
}
