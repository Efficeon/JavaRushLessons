package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов
длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<int[]>();

        int mas[] = {11, 12, 13, 14, 15};
        int mas1[] = {21, 22};
        int mas2[] = {31, 32, 33, 34};
        int mas3[] = {41, 42, 43, 44, 45, 46, 47};
        int mas4[] = {};
        list.add(mas);
        list.add(mas1);
        list.add(mas2);
        list.add(mas3);
        list.add(mas4);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array : list)
        {
            for (int x : array)
            {
                System.out.println(x);
            }
        }
    }
}
