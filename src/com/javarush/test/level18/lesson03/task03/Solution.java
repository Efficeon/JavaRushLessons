package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Byte> list = new ArrayList<Byte>();
        TreeMap<Byte, Integer> map = new TreeMap<Byte, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
                if (j.equals(i)) x++;
            }
            map.put(i, x);
        }
        int t = 0;
        byte v = 0;
        for (Map.Entry e : map.entrySet())
        {
            if ((int) e.getValue() > t)
            {
                t = (int) e.getValue();
                v = (byte) e.getKey();
            }
        }
        System.out.print(v + " ");
        for (Map.Entry e : map.entrySet())
        {
            if ((Integer) e.getValue() == t && (((Byte) e.getKey() != v)))
                System.out.print(v + " ");
        }
        reader.close();
        file.close();
    }
}
