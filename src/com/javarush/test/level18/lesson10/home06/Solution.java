package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
public class Solution
{
    public static void main(String[] args) throws IOException

    {

        if (!(args[0] == null))
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
            ArrayList<Integer> list = new ArrayList<Integer>();

            while (fileInputStream.available() > 0)
            {
                int i = (byte) fileInputStream.read();
                map.put(i, 0);
                list.add(i);
            }

            for (Map.Entry entry : map.entrySet())
            {
                int y = 0;
                for (int j : list)
                {
                    if (entry.getKey().equals(j))
                        y++;
                    entry.setValue(y);
                }
            }
            for (Map.Entry entry : map.entrySet())
            {
                int c = (int) entry.getKey();
                System.out.println((char) c + " " + entry.getValue());
            }
            reader.close();
            fileInputStream.close();
        }
    }
}
