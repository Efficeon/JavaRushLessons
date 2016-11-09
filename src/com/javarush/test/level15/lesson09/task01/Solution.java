package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution
{
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(1.1, "a");
        labels.put(2.1, "b");
        labels.put(3.1, "c");
        labels.put(4.1, "d");
        labels.put(5.1, "e");

    }

    public static void main(String[] args)
    {
        System.out.println(labels);
    }
}
