package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> users = new HashMap<String, String>();
        //Iterator<Map.Entry<String, String>> iterator = users.entrySet().iterator();

        while (true)
        {
            String key = reader.readLine();
            if (key.isEmpty()) break;
            String date = reader.readLine();
            if (date.isEmpty()) break;
            users.put(key, date);
        }

        String houseNumber = reader.readLine();

        for (Map.Entry<String, String> s : users.entrySet())
        {
            if (houseNumber.equals(s.getKey()))
                System.out.println(s.getValue());
        }

        /*while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            if(key.equals(houseNumber))
                System.out.println(value);
        }*/
    }
}
