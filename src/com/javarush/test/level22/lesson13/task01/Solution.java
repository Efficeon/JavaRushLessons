package com.javarush.test.level22.lesson13.task01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<String>();
        StringTokenizer token = new StringTokenizer(query, delimiter);
        while (token.hasMoreTokens()){
            list.add(token.nextToken());
        }

        String[]mass = list.toArray(new String[list.size()]);
        return mass;
    }
}
