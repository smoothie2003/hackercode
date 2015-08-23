package com.company;

import java.util.Scanner;

/**
 * Created by Varun on 6/6/2015.
 */
public class JavaEndOfFile {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer output = new StringBuffer();

        int lineNumber = 1;

        while(in.hasNextLine()) {
            output.append(lineNumber).append(" ").append(in.nextLine()).append("\n");
            lineNumber++;
        }

        System.out.println(output.toString());
    }
}
