package com.company.sorting;

import java.util.*;
public class QuickSortTwo {
       
          static void quickSort(int[] ar) {
              
              int p = ar[0];
              int rightPointer = ar.length-1;
              int leftPointer = 1;
              
              ar = quickSort(p, rightPointer, leftPointer, ar);
              printArray(ar);
       }   
 
        static int[] quickSort(int pivotValue, int rightPointer, int leftPointer, int[] ar) {
            int[] result = new int[leftPointer-rightPointer+1];
            int leftIndex = leftPointer;
            int rightIndex = rightPointer;
            int partitionValue = pivotValue;

            for(int i=leftPointer; i<ar.length; i++) {
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

            return ar;
            
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