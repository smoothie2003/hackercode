package com.company;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Varun on 6/5/2015.
 */
public class JavaLoops {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a,b,n;
        int numberOfIntegers = in.nextInt();

        for (int i=0; i< numberOfIntegers; i++) {
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();

            /*String getValue = getSequence(a, b, n);*/

            int[] bValues = new int[n];

            for (int j=0; j<n; j++) {
                bValues[j] = ((int) Math.pow(2, j))*b;
            }

            for(int z=0; z<n; z++) {
                int index = z;
                int value = a;
                while(index > -1) {
                    value+=bValues[index];
                    index--;
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    /*private static String getSequence(int a, int b, int n) {
        if(n == 0) {
            return String.valueOf(a+b);
        } else {
            String value = getSequence(a, b, n-1);
        }
    }*/
}
/**
 Problem Statement

 In this problem you will test your knowledge of Java loops. Given three integers a, b, and n, output the following series:

 a+20b,a+20b+21b,......,a+20b+21b+...+2n?1b

 Input Format

 The first line will contain the number of integers, t. Each of the next t lines will have three integers, a, b, and n.

 Constraints:

 0?a,b?50
 1?n?15

 Output Format

 Print the answer to each test case in seperate lines.

 Sample Input

 2
 0 2 10
 5 3 5

 Sample Output

 2 6 14 30 62 126 254 510 1022 2046
 8 14 26 50 98

 Explanation

 In the first case:

 1st term=0+1*2=2
 2nd term=0+1*2+2*2=6
 3rd term=0+1*2+2*2+4*2=14

 and so on.
 */