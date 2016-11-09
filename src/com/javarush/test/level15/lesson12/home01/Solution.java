package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Object> list = new ArrayList<Object>();
        while (true)
        {
            String x = reader.readLine();
            if (x.equals("exit")) break;
            else if (x.contains(".")) print(Double.parseDouble(x));
            else if (metShort(x)) print(Short.parseShort(x));
            else if (metInteger(x)) print(Integer.parseInt(x));
            else print(x);
        }
    }

    private static boolean metShort(String x)
    {
        try
        {
            Short n = Short.parseShort(x);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    private static boolean metInteger(String x)
    {
        try
        {
            Integer n = Integer.parseInt(x);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }

    }


    public static void print(Double value)
    {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value)
    {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value)
    {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value)
    {
        System.out.println("Это тип Integer, значение " + value);
    }
}
