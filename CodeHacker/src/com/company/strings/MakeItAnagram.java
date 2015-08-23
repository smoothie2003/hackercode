package com.company.strings;

import java.util.Scanner;

/**
 * Created by Varun on 6/14/2015.
 */
public class MakeItAnagram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[] input1 = input.next().toCharArray();
        char[] input2 = input.next().toCharArray();

        int[] input1Values = new int[26];
        int[] input2Values = new int[26];

        int deletions = 0;

        for(int i=0; i<input1.length; i++) {
            //error checking required for character 97 - 122
            int index = ((int) Character.toLowerCase(input1[i]))%97;

            input1Values[index]++;
        }

        for(int j=0; j<input2.length; j++) {
            //error checking required for character 97 - 122
            int index = ((int) Character.toLowerCase(input2[j])%97);

            input2Values[index]++;
        }

        for(int k=0; k<input1Values.length; k++) {
            int count1 = input1Values[k];
            int count2 = input2Values[k];

            int diff = Math.abs(count1-count2);

            deletions+=diff;
        }

        System.out.println(deletions);

        input.close();
    }
}
