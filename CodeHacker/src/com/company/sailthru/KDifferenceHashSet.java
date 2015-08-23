package com.company.sailthru;

import java.util.HashSet;
import java.util.Scanner;

public class KDifferenceHashSet {
    public static void main(String args[] ) throws Exception {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        HashSet<Integer> distinctIntegers = new HashSet<Integer>();
        boolean notInHashSet = false;
        int counter = 0;

        for (int i = 0; i < n; i++) {
            int value = input.nextInt();
            notInHashSet = distinctIntegers.add(value);

            if (notInHashSet) {
                if (distinctIntegers.contains(value + k)) {
                    counter++;
                }

                if(distinctIntegers.contains(value - k)) {
                    counter++;
                }
            }

        }

        System.out.println(counter);
    }
}