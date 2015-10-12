package ui;


import dto.Controller;
import operations.ASKHotel;
import operations.Guest;
import operations.Hotel;
import operations.Room;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller cont = (Controller)ctx.getBean("controller");
        cont.runMenu();

        
        
        System.out.println("Please enter the date of your stay. (YYYY,MM,DD)");
    }
}
