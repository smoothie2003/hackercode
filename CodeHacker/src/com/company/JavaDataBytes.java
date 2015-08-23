package com.company;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class JavaDataBytes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        in.next();

        while(in.hasNext()) {
            boolean isShort = in.hasNextShort();
            boolean isInt = in.hasNextInt();
            boolean isLong = in.hasNextLong();
            boolean isByte = in.hasNextByte();

            String value = in.next();
            System.out.print(value);

            if(!isShort && !isInt && !isLong && !isByte) {
                System.out.print(" can't be fitted anywhere.\n");
            } else {
                System.out.println(" can be fitted in:");
            }

            if(isByte) {
                System.out.println("* byte");
            }

            if(isShort) {
                System.out.println("* short");
            }
            if(isInt) {
                System.out.println("* int");
            }
            if(isLong) {
                System.out.println("* long");
            }

        }

    }


}
