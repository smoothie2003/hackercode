package com.company.strings;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Varun on 6/12/2015.
 */
public class PanGram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String testCase = input.nextLine();

        char[] testCaseAsArray = testCase.toCharArray();

        HashSet<Character> characterHashSet = new HashSet<Character>();

        for(int i = 0; i < testCaseAsArray.length; i++) {
            char value = Character.toLowerCase(testCaseAsArray[i]);
            int integerValue = (int) value;

            if(integerValue >= 97 && integerValue <= 122) {
                characterHashSet.add(value);
            }
        }

        if(characterHashSet.size() == 26) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }

        input.close();
    }
}
