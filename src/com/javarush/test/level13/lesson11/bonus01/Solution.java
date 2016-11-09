package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5 8 11 3 2 10 Пример вывода:2 8 10 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> set = new ArrayList<Integer>();

        InputStream inputStream = new FileInputStream(reader.readLine());
        //InputStream inputStream = new FileInputStream("/home/efficeon/resC.txt");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream));
        String f;
        while ((f = (reader1.readLine())) != null)
        {
            Integer i = Integer.parseInt(f);

            set.add(i);
        }

        Collections.sort(set);
        for (Integer ss : set)
        {
            if (ss % 2 == 0)
                System.out.println(ss);
        }

    }
}
