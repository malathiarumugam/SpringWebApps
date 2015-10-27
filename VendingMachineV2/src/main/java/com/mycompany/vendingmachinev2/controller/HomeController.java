package com.mycompany.vendingmachinev2.controller;

import com.mycompany.vendingmachinev2.model.Vend;
import com.mycompany.vendingmachinev2.dao.VendingDao;
import com.mycompany.vendingmachinev2.model.Item;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    private VendingDao dao;

    @Inject
    public HomeController(VendingDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

//    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Item getContact(@PathVariable("id") String id) {
//        return dao.findItemByCode(id);
//    }
//    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteContact(@PathVariable("id") String id) {
//        dao.removeItem(id);
//    }
//    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void putContact(@PathVariable("id") String id, @RequestBody Item item) {
//        item.setCode(id);
//    }


    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getAllItems() {
// get all of the Contacts from the data layer
        return dao.getAllItems();
    }

    @RequestMapping(value = "item/vend", method = RequestMethod.PUT)
    @ResponseBody
    public double buyItem(@RequestBody Vend item) {
        double cost = dao.findItemByCode(item.getCode()).getCost();
        if (item.getMoney() >= cost) {
            dao.lowerItemCount(dao.findItemByCode(item.getCode()));
            return item.getMoney() - cost;
        } else {
            return item.getMoney() - cost;
        }
    }
}
