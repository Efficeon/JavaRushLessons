package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

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
        String d = reader.readLine();

        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int c1 = Integer.parseInt(c);
        int d1 = Integer.parseInt(d);
        int a2;
        int b2;

        if (a1 > b1)
        {
            a2 = a1;
        } else
        {
            a2 = b1;
        }

        if (c1 > d1)
        {
            b2 = c1;
        } else
        {
            b2 = d1;
        }

        if (a2 > b2)
        {
            System.out.print(a2);
        } else
        {
            System.out.print(b2);
        }
    }
}
