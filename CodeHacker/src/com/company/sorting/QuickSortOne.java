package com.company.sorting;

import java.util.*;
public class QuickSortOne {
       
          static void partition(int[] ar) {
              int[] result = new int[ar.length];
              /*int midIndex = (int) (Math.floor(ar.length/2.0));
              int leftIndex = midIndex - 1;
              int rightIndex = midIndex + 1;
              
              for(int i=0; i<ar.length; i++) {
                  if(i == 0) {
                    result[midIndex] = ar[i];                  
                  }
                  
                  if(ar[i] > result[midIndex]) {
                      result[rightIndex] = ar[i];
                      rightIndex++;
                  } else if (ar[i] < result[midIndex]) {
                      result[leftIndex] = ar[i];
                      leftIndex--;
                  }
              }*/
              
              int leftIndex = 0;
              int rightIndex = ar.length-1;
              int partitionValue = ar[0];
              
              for(int i=1; i<ar.length; i++) {
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
                    
              printArray(result);
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
           partition(ar);
       }    
   }
