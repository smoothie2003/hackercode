package com.company.strings;

import java.util.Scanner;

/**
 * Created by Varun on 6/12/2015.
 */
public class FunnyString {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char minValue = 'a';
        char maxValue = 'A';
        char someValue = Character.toLowerCase(maxValue);

        System.out.println("Min value : " + (int) minValue);
        System.out.println("Max value : " + (int) maxValue);
        System.out.println("Some value : " + (int) someValue);

        boolean isFunny = false;
        try {
            int testCases = input.nextInt();

            for(int i = 0; i<=testCases; i++) {
                String testCase = input.next();
                isFunny = funnyOrNot(testCase);

                if(isFunny) {
                    System.out.println("Funny");

                } else {
                    System.out.println("Not Funny");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            input.close();
        }
    }

    private static boolean funnyOrNot(String testCase) {

        char[] testCaseAsArray = testCase.toCharArray();
        char[] reverseTestCaseAsArray = reverseArray(testCaseAsArray);

        for(int i = 0, j = 1; j < testCaseAsArray.length; i++, j++) {
            int value1 = (int) testCaseAsArray[i];
            int value2 = (int) testCaseAsArray[j];

            int rValue1 = (int) reverseTestCaseAsArray[i];
            int rValue2 = (int) reverseTestCaseAsArray[j];

            int val = Math.abs(value1 - value2);
            int rval = Math.abs(rValue1 - rValue2);

            if(val != rval) {
                return false;
            }
        }

        return true;
    }

    private static char[] reverseArray(char[] testCaseAsArray) {

        int i = 0;
        int j = testCaseAsArray.length-1;
        char[] reverseArray = new char[testCaseAsArray.length];
        while(i<=j) {
            reverseArray[i] = testCaseAsArray[j];
            reverseArray[j] = testCaseAsArray[i];

            i++;
            j--;
        }

        return reverseArray;
    }
}

/*


Problem Statement

Suppose you have a string S which has length N and is indexed from 0 to N?1. String R is the reverse of the string S. The string S is funny if the condition |Si?Si?1|=|Ri?Ri?1| is true for every i from 1 to N?1.

(Note: Given a string str, stri denotes the ascii value of the ith character (0-indexed) of str. |x| denotes the absolute value of an integer x)

Input Format

First line of the input will contain an integer T. T testcases follow. Each of the next T lines contains one string S.

Constraints

    1<=T<=10
    2<=length of S<=10000

Output Format

For each string, print Funny or Not Funny in separate lines.

Sample Input

2
acxz
bcxz

Sample Output

Funny
Not Funny

Explanation

Consider the 1st testcase acxz

here

|c-a| = |x-z| = 2
|x-c| = |c-x| = 21
|z-x| = |a-c| = 2

Hence Funny.

Consider the 2st testcase bcxz

here

|c-b| != |x-z|

Hence Not Funny.

 */
