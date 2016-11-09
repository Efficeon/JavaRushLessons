package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte i = 44;
        int j = 0;
        try
        {
            FileInputStream file = new FileInputStream(reader.readLine());
            while (file.available() > 0)
            {
                if (i == file.read()) j++;
            }
            System.out.println(j);
            reader.close();
            file.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
