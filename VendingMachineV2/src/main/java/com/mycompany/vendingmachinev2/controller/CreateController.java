package com.mycompany.vendingmachinev2.controller;

import com.mycompany.vendingmachinev2.dao.VendingDao;
import com.mycompany.vendingmachinev2.model.Item;
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
public class CreateController {

    private VendingDao dao;

    @Inject
    public CreateController(VendingDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String displayCreatePage() {
        return "create";
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Item createItem(@Valid @RequestBody Item item) {
        for (Item a : dao.getAllItems()) {
            if (a.getCode().equalsIgnoreCase(item.getCode())) {
                return null;
            }
        }
        dao.addItem(item);
        return item;
    }

    @RequestMapping(value = "/item/{code}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putItem(@PathVariable("code") String code,@RequestBody Item item) {
        item.setCode(code);
        dao.updateItem(item);
    }

    @RequestMapping(value = "/item/{code}", method = RequestMethod.GET)
    @ResponseBody
    public Item getItem(@PathVariable("code") String code) {
        return dao.findItemByCode(code);
    }

    @RequestMapping(value = "/item/{code}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable("code") String code) {
        dao.removeItem(code);
    }

}
