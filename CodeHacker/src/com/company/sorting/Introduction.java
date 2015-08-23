package com.company.sorting;

import java.util.Scanner;

/**
 * Created by Varun on 6/6/2015.
 */
public class Introduction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int valueToSearch;
        int sizeOfArray;
        int[] arrayOfNumbers;

        valueToSearch=in.nextInt();
        sizeOfArray=in.nextInt();

        arrayOfNumbers = new int[sizeOfArray];

        for(int i=0;i<sizeOfArray;i++) {
            arrayOfNumbers[i]=in.nextInt();
        }

        int index = findIndex(arrayOfNumbers, valueToSearch);

        System.out.println(index);
    }

    private static int findIndex(int[] arrayOfNumbers, int valueToSearch) {
       for(int i=0; i < arrayOfNumbers.length; i++) {
           if(arrayOfNumbers[i] == valueToSearch) {
               return i;
           }
       }
        System.out.println("Not Found");
        return -1;
    }
}
