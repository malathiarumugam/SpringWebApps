



package com.mycompany.dvdlibraryv4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListAllController {
    
    @RequestMapping(value={"/ListAll"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "ListAll";
    }
    
    
}