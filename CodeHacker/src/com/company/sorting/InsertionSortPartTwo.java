package com.company.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Varun on 6/15/2015.
 */
public class InsertionSortPartTwo {

    private static int call = 1;

    static void quickSort(int[] ar) {

        int[] result;

        result = quickSort(ar[0], ar.length-1, 0, ar);

        //result = quickSortSimple(1, ar.length-1, ar);

        printArray(result);
    }

    private static int[] quickSortSimple(int left, int right, int[] ar) {

        int[] results = ar;
        int pivot = ar[0];

        while(left <= right) {
            while(ar[left] < pivot) {
                results[left-1] = ar[left];
                left++;

            }

            while(ar[right] > pivot) {
                results[right] = ar[right];
                right--;
            }

            if(left <= right) {
                results[left-1] = ar[right];
                left++;
                results[right] = ar[left];
                right--;
            }
        }

        results[left] = pivot;

        return results;

    }

    static int[] quickSort(int pivotValue, int rightPointer, int leftPointer, int[] ar) {

        if(leftPointer == -1 || rightPointer == -1) {
            int[] returnValue = new int[1];
            returnValue[0] = pivotValue;

            return returnValue;
        }

        int[] result = new int[rightPointer-leftPointer+1];

        int leftIndex = leftPointer;
        int rightIndex = rightPointer;
        int partitionValue = pivotValue;

        for(int i = leftPointer+1; i<rightPointer+1; i++) {
            if (ar[i] < partitionValue) {
                result[leftIndex] = ar[i];
                leftIndex++;
            }
        }

        for(int i=leftPointer+1; i<rightPointer+1; i++) {
            if(ar[i] > partitionValue) {
                result[rightIndex] = ar[i];
                rightIndex--;
            }
            if(ar[i] < partitionValue) {
                result[leftIndex] = ar[i];
                leftIndex++;
            }
        }

        result[leftIndex] = partitionValue;

        //call left

        if(rightPointer-leftPointer > 2) {

            int[] subLeft;
            subLeft = quickSort(result[0], leftIndex - 1, 0, Arrays.copyOfRange(result, 0, leftIndex));
            printArray(subLeft);

            for(int i = 0; i < subLeft.length; i++) {
                result[i] = subLeft[i];
            }

            //call right
            int[] subRight;
            subRight = quickSort(result[leftIndex + 1], result.length - leftIndex - 2, 0, Arrays.copyOfRange(result, leftIndex + 1, result.length));
            printArray(subRight);

            for(int i = 0; i < subRight.length; i++) {
                result[leftIndex + 1 + i] = subRight[i];
            }
        }

        return result;

    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        quickSort(ar);
    }
}
