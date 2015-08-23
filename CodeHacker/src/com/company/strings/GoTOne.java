package com.company.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GoTOne {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();

        String ans = "";

        char[] inputCA = inputString.toCharArray();

        HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();

        for(int i = 0; i < inputCA.length; i++) {
            if(characterMap.get(inputCA[i]) == null) {
                characterMap.put(inputCA[i], new Integer(1));
            } else {
                Integer value = characterMap.get(inputCA[i]);
                value++;
                characterMap.put(inputCA[i], value);
            }
        }

        Set<Character> characterSet = characterMap.keySet();
        int odd = 0;

        for(Character character : characterSet) {
            Integer count = characterMap.get(character);

            if(count % 2 > 0) {
                odd++;
            }
        }

        if(inputCA.length % 2 == 0 && odd == 0) {
            ans = "YES";
        } else if (inputCA.length % 2 > 0 && odd == 1) {
            ans = "YES";
        } else {
            ans = "NO";
        }

        System.out.println(ans);
        myScan.close();
    }
}
