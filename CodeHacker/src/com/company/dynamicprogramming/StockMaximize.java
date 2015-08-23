package com.company.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Varun on 6/13/2015.
 */
public class StockMaximize {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int testCases = input.nextInt();

        for(int i = 1; i<=testCases; i++) {
            int size = input.nextInt();
            long[] sizeOfArray = new long[size];

            for(int j=0; j<sizeOfArray.length; j++) {
                sizeOfArray[j] = input.nextInt();
            }

            long maxProfit = giveMaxProfit(sizeOfArray);

            System.out.println(maxProfit);

        }

    }

    private static long giveMaxProfit(long[] priceArray) {

        long totalProfit = 0;

        for(int i = 0; i < priceArray.length; i++) {
            long tempTotalProfit = maxProfitForBuyOnOneDay(priceArray, i);

            if(tempTotalProfit > 0) {
                totalProfit += tempTotalProfit;
            }
        }

        return totalProfit;
    }

    private static long maxProfitForBuyOnOneDay(long[] priceArray, int i) {

        long buyPrice = priceArray[i];
        long bestProfit = 0;

        for(int j = i+1; j < priceArray.length; j++) {
            long sellPrice = priceArray[j];

            long tempProfit = sellPrice - buyPrice;

            if(tempProfit > bestProfit) {
                bestProfit = tempProfit;
            }

        }

        return bestProfit;
    }

}
