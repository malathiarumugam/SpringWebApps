package com.mycompany.UI;

import com.mycompany.dto.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller cont =  (Controller) ctx.getBean("dvdcontroller");
        cont.runProgram();        
    }
}
