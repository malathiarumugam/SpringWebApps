/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author apprentice
 * 
 */
@Configuration
@EnableAspectJAutoProxy
public class Maid {
    public void placeMint(){
        System.out.println("Mint placed!!");
    }
    public void cleanRoom(){
        System.out.println("Room cleaned!!");
    }
    
}
