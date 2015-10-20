/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class JavaApplication8 {
    /*
     recursively return every possible different combination of an arbitrary length array's element
     */

    static int i = 0;

    public static void returnLength(String[] name) {
        System.out.println(name[i].length());
        i++;
        if (i >= name.length) {
            return;
        }
        returnLength(name);
    }
    public void print(int x) {
        System.out.println("int");
    }

    public static void main(String[] args) {
//        String[] names = {"kevin", "cheese", "ford", "text", "a", "bb", "curse", "longwordssda"};
//        returnLength(names);
//
//        fly(new int[]{1, 2, 3});
//        fly(3, 2, 3);
//        StringBuilder sb = new StringBuilder("Tree");
//        sb.append("s on trees");
//        System.out.println(sb);
//
//        List<String> bunnies = new ArrayList<>();
//        bunnies.add("long ear");
//        bunnies.add("floppy");
//        bunnies.add("hoppy");
//        System.out.println(bunnies);
//        bunnies.removeIf(s -> s.charAt(0) != 'h');
//        System.out.println(bunnies);
//
//        howMany(true, new boolean[2]);
//        howMany(true, true, true);
//        howMany(true, true, true, true, true);
        JavaApplication8 steve = new JavaApplication8();
        steve.climb();
        steve.climb();
        short x = 5;
        steve.print(x);
        
        String kevin = "This is a long string";
        StringBuilder sb = new StringBuilder(kevin);
        String nivek = sb.reverse().toString();
        
        System.out.println(nivek);
        
        String cheese = nivek.replaceAll("\\s", "");
        System.out.println(cheese);
    }

    public static int howMany(boolean b, boolean... b2) {
        
        System.out.println("working");
        return 5;
    }

    public static void fly(int... tree) {
        System.out.println(tree[0]);
        
    }

    public void climb() {
        System.out.println("climb ");
    }
}
