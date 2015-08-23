package com.company.sorting;

import java.util.Scanner;

/**
 * Created by Varun on 6/8/2015.
 */
public class MergeSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int inputArraySize = input.nextInt();

        int[] unSortedArray = new int[inputArraySize];

        for(int i = 0; i < unSortedArray.length; i++) {
            unSortedArray[i] = input.nextInt();
        }

        int[] sortedArray = mergeSort(unSortedArray);

        StringBuffer array = new StringBuffer();

        for(int j = 0; j < sortedArray.length; j++) {
            array.append(sortedArray[j]).append(" ");
        }

        System.out.println(array.toString());

    }

    public static int[] mergeSort(int[] unsortedArray) {
            return null;
    }

}
