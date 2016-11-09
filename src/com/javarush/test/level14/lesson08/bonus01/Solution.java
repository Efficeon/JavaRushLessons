package com.javarush.test.level14.lesson08.bonus01;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();
        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] x = {12, 15, 16};
            for (int i = 0; i < 10; i++)
            {
                int z = x[i];
            }

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] x = new int[-10];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object szStr[] = new String[10];
            szStr[0] = new Character('*');
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object ch = new Character('*');
            System.out.println((Byte) ch);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String szShortString = "123";
            char chr = szShortString.charAt(10);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String answerStr = "";
            TextField textField1, textField2;
            textField1 = new TextField(20);
            textField2 = new TextField(20);
            String str1 = textField1.getText();
            String str2 = textField2.getText();
            int int1 = Integer.parseInt(str1);
            int int2 = Integer.parseInt(str2);
            int answer = int1 / int2;
            answerStr = str1 + "/" + str2 + "=" + String.valueOf(answer);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            ArrayList<String> a = new ArrayList<String>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            b.contains(a.get(0));
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Solution test = new Solution();
            test.clone();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            InputStream stream = new FileInputStream("test");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}

