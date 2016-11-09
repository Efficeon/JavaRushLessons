package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int mas[] = new int[5];
        for (int i = 0; i < 5; i++)
        {
            String num = reader.readLine();
            mas[i] = Integer.parseInt(num);
        }
        Arrays.sort(mas);
        for (int i = 0; i < mas.length; i++)
        {
            System.out.println(mas[i] + " ");
        }

    }
}
