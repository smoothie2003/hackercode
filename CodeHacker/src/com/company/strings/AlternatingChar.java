package com.company.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AlternatingChar {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCases = input.nextInt();

        for(int i = 1; i <= testCases; i++) {
            String testCase = input.next();
            /*System.out.println(testCase);*/
            char[] tCArray = testCase.toCharArray();

            int deletions = 0;

            for(int j = 1; j < tCArray.length; j++) {
                if(tCArray[j] == tCArray[j-1]) {
                    deletions++;
                }
            }

            System.out.println(deletions);
        }

        input.close();
    }
}
