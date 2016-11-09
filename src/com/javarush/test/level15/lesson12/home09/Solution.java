package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String line = reader.readLine();
        line = line.substring(line.indexOf("?") + 1);


        for (String i : line.split("&"))
        {
            list.add(i);
        }
        for (String s : list)
        {
            if (s.contains("="))
            {
                int i = s.indexOf('=');
                System.out.print(s.substring(0, i) + " ");
            } else
                System.out.print(s + " ");
        }
        System.out.println("");
        for (String s : list)
        {
            if (s.startsWith("obj="))
            {
                int i = s.indexOf('=');
                try
                {
                    alert(Double.parseDouble(s.substring(i + 1, s.length())));
                }
                catch (Exception e)
                {
                    alert(s.substring(i + 1, s.length()));
                }
            }
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
