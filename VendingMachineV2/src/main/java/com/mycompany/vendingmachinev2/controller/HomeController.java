package com.mycompany.vendingmachinev2.controller;

import com.mycompany.vendingmachinev2.model.VendingInfo;
import com.mycompany.vendingmachinev2.dao.VendingDao;
import com.mycompany.vendingmachinev2.model.Change;
import com.mycompany.vendingmachinev2.model.ChangeString;
import com.mycompany.vendingmachinev2.model.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private VendingDao dao;

    @Inject
    public HomeController(VendingDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping(value={"/mainAjaxPage", "/"}, method=RequestMethod.GET)
    public String displayMainAjaxPage() {
        return "mainAjaxPage";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getAllItems() {
// get all of the Contacts from the data layer
        return dao.getAllItems();
    }

    @RequestMapping(value = "item/vend", method = RequestMethod.PUT)
    @ResponseBody
    public BigDecimal buyItem(@RequestBody VendingInfo item) {
        double cost = dao.findItemByCode(item.getCode()).getCost().doubleValue();
        double money = (item.getMoney().doubleValue() + item.getLeftover());

        if (money >= cost) {
            dao.lowerItemCount(item.getCode());
            BigDecimal d = new BigDecimal(money - cost);
            return d;
        } else {
            BigDecimal d = new BigDecimal(money * -1);
            return d;
        }
    }

    @RequestMapping(value = "item/change", method = RequestMethod.PUT)
    @ResponseBody
    public ChangeString returnChange(@RequestBody Change change) {
        double total = change.getTotal().doubleValue() * 100;
        double quarter = 0;
        double dime = 0;
        double nickel = 0;
        int penny = 0;

        if (total >= 100) {
            double dollars = (total - total % 25);
            quarter = dollars / 25;

            total -= quarter * 25;
        }
        if (total >= 75 && total % 75 >= 0) {
            quarter = 3;
            total -= 75;
        }
        if (total >= 50 && total % 50 >= 0) {
            quarter = 2;
            total -= 50;
        }
        if (total >= 25 && total % 25 >= 0) {
            quarter = 1;
            total -= 25;
        }
        if (total >= 20 && total % 20 >= 0) {
            dime = 2;
            total -= 20;
        }
        if (total >= 10 && total % 10 >= 0) {
            dime = 1;
            total -= 10;
        }
        if (total >= 5 && total % 5 >= 0) {
            nickel = 1;
            total -= 5;
            penny = (int)Math.round(total);
        }
        ChangeString string = new ChangeString("Your change is " + (int) quarter + " quarters " + (int) dime + " dimes " + (int) nickel + " nickel " + penny + " pennies");
        return string;
    }
}
