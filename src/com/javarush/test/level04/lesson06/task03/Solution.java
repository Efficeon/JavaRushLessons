package com.javarush.test.level04.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();

        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int c1 = Integer.parseInt(c);

        if (a1 > b1 && a1 > c1)
        {
            System.out.println(a1);
            if (b1 > c1)
            {
                System.out.println(b1);
                System.out.println(c1);
            } else
            {
                System.out.println(c1);
                System.out.println(b1);
            }
        } else
        {
            if (b1 > a1 && b1 > c1)
            {
                System.out.println(b1);
                if (a1 > c1)
                {
                    System.out.println(a1);
                    System.out.println(c1);
                } else
                {
                    System.out.println(c1);
                    System.out.println(a1);
                }
            }
        }
        if (c1 > a1 && c1 > b1)
        {
            if (c1 > a1 && b1 > a1)
            {
                System.out.println(c1);
                System.out.println(b1);
                System.out.println(a1);
            } else
            {
                System.out.println(c1);
                System.out.println(a1);
                System.out.println(b1);
            }
        }
    }
}





