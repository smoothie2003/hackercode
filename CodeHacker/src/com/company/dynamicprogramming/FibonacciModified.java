package com.company.dynamicprogramming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Varun on 6/12/2015.
 */
public class FibonacciModified {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> values = new ArrayList<>();

        BigInteger value1 = BigInteger.valueOf(input.nextLong());

        BigInteger value2 = BigInteger.valueOf(input.nextLong());
        int sequence = input.nextInt();

        BigInteger fibonaaci = getFibonaaci(value1, value2, sequence);

        System.out.println(fibonaaci);
        input.close();

    }

    private static BigInteger getFibonaaci(BigInteger value1, BigInteger value2, int sequence) {
        if(sequence == 1) {
            return value1;
        }

        if(sequence == 2) {
            return value2;
        }

        if(sequence == 3) {
            BigInteger value = value2.multiply(value2).add(value1);
            return value;
        }

        BigInteger base = getFibonaaci(value1, value2, sequence-1);
        BigInteger secondFib = base.multiply(base).add(getFibonaaci(value1, value2, sequence-2));

        return secondFib;
    }
}
