package com.java.core;

public class Test {

    public static void main(String args[]) {
        
        int decimal = 100;
        int octal = 0144; // also can start with 00
        int hex = 0x64;
        int binary = 0b1100100;
        
        int n = 01010;
        System.out.println("n = "+ Integer.decode(String.valueOf(n)));
        
        
        System.out.println(String.format("%02d", n));
        
        String st = String.valueOf(n);
        System.out.println("str = " + st);
    }
}
