package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        int n = Integer.parseInt(a);
        int m = Integer.parseInt(b);

        for (int i = 0; i < n; i++)
        {
            for (int f = 0; f < m; f++)
            {
                System.out.print("8");
            }
            System.out.println("");
        }

    }
}
