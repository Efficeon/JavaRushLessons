package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        Set<Integer> set = new HashSet<Integer>();
        set.add(2);
        set.add(32);
        set.add(16);
        set.add(123);
        set.add(700);
        set.add(4);
        set.add(77);
        set.add(19);
        set.add(568);
        set.add(23);
        set.add(12);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(201);
        set.add(2222);
        set.add(90);
        set.add(1);
        set.add(11);
        set.add(56);

        return (HashSet<Integer>) set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Integer x = iterator.next();
            if (x > 10)
                iterator.remove();

        }
        return (HashSet<Integer>) set;
    }
}
