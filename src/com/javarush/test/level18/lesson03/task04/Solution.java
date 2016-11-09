package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
        ArrayList<Byte> list = new ArrayList<Byte>();
        FileInputStream file = new FileInputStream(reader.readLine());

        while (file.available() > 0)
        {
            list.add((byte) file.read());
        }

        for (Byte i : list)
        {
            int x = 0;
            for (Byte j : list)
            {
                if (i.equals(j)) x++;
            }
            map.put(i, x);
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry e : map.entrySet())
        {
            if ((int) e.getValue() < min)
            {
                min = (int) e.getValue();
            }
        }
        for (Map.Entry e : map.entrySet())
        {
            if (e.getValue().equals(min)) System.out.print(e.getKey() + " ");
        }
        file.close();
        reader.close();
    }
}