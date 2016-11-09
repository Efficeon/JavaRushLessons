package com.javarush.test.level05.lesson12.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма».
Вывести на экран полученную сумму.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String s = "сумма";
        for (; ; )
        {
            String a = reader.readLine();

            if (a.equals(s))
            {
                System.out.println(sum);
                break;
            } else
            {
                int a1 = Integer.parseInt(a);
                sum += a1;
            }
        }
    }
}
