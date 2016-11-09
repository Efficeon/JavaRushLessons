package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int mas[] = new int[5];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        int minimum = min(a, b);

        System.out.println("Minimum = " + minimum);*/
        for (int x = 0; x < 5; x++)
        {
            // String num = ();
            mas[x] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(mas);
        System.out.println("Minimum = " + mas[0]);

    }


    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }

}
