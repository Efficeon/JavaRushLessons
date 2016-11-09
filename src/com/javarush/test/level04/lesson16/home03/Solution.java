package com.javarush.test.level04.lesson16.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int r;
        int s;
        while (s != -1)
            String a = reader.readLine();
        {

            int y = Integer.parseInt(a);
            r += y;
            s = y;
        }
        System.out.println(r);
    }
}


//напишите тут ваш код


