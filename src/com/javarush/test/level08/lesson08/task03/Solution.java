package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Дубравский", "Леонид");
        map.put("Мележик", "Лилия");
        map.put("Ветров", "Валерий");
        map.put("Подобежов", "Леонид");
        map.put("Журба", "Сергей");
        map.put("Андроненко", "Сергей");
        map.put("Адамчук", "Анна");
        map.put("Болотова", "Виктория");
        map.put("Дубровский", "Олег");
        map.put("Василенко", "Даринка");

        return (HashMap<String, String>) map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int x = 0;
        for (Map.Entry<String, String> test : map.entrySet())
        {

            String nametest = test.getValue();
            if (nametest.equals(name))
            {
                x++;
            }

        }

        return x;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int x = 0;
        for (Map.Entry<String, String> test1 : map.entrySet())
        {
            String nametest1 = test1.getKey();
            if (nametest1.equals(lastName))
            {
                x++;
            }

        }
        return x;
    }
}
