package com.company.sorting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Varun on 6/21/2015.
 */
public class QuickSortTwoSecondTry {

    static ArrayList<Integer> quickSort(ArrayList<Integer> ar) {

        if(ar.size() == 1 || ar.size() == 0) {
            return ar;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();

        int p = ar.get(0);

        ArrayList<Integer> rightArray = new ArrayList<Integer>();
        ArrayList<Integer> leftArray = new ArrayList<Integer>();

        for(int i = 1; i < ar.size(); i++) {
            if(ar.get(i) > p) {
                rightArray.add(ar.get(i));
            }

            if(ar.get(i) < p) {
                leftArray.add(ar.get(i));
            }
        }

        leftArray = quickSort(leftArray);
        rightArray = quickSort(rightArray);

        result.addAll(leftArray);
        result.add(p);
        result.addAll(rightArray);

        printArray(result.toArray());

        return result;
    }

    static void printArray(Object[] ar) {
        for(Object n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> ar = new ArrayList<Integer>(n);
        for(int i=0;i<n;i++){
            ar.add(in.nextInt());
        }
        quickSort(ar);
    }
}
