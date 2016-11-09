package com.javarush.test.level04.lesson10.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String b = reader.readLine();
        String a = reader.readLine();
        int s = Integer.parseInt(a);

        while (s >= 1)
        {
            System.out.println(b);
            s--;
        }

    }
}
