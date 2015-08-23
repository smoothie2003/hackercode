package com.company.sailthru;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Varun on 6/27/2015.
 */
public class ModifiedFibonacciIterative {

    /*
 * Complete the function below.
 */

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
        int _n;
        _n = Integer.parseInt(in.nextLine());

        res = fibonacci(_n);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    static int[] fibonacci(int n) {

        if(n < 1 || n > 10) {
            System.out.println("Invalid input");
            return new int[0];
        }

        int[] results = new int[n];

        for(int i = 0; i < n; i++) {

            if (i == 0) {
                results[i] = 0;
            } else if ( i == 1) {
                results[i] = 1;
            } else {
                results[i] = results[i-1] + results[i-2];
            }
        }

        return results;

    }


}
