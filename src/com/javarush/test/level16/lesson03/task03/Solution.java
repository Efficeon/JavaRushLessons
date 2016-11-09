package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution
{
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args)
    {

        SpecialThread thred = new SpecialThread();
        Thread Thread = new Thread(thred);
        list.add(Thread);

        SpecialThread thred1 = new SpecialThread();
        Thread Thread1 = new Thread(thred1);
        list.add(Thread1);

        SpecialThread thred2 = new SpecialThread();
        Thread Thread2 = new Thread(thred2);
        list.add(Thread2);

        SpecialThread thred3 = new SpecialThread();
        Thread Thread3 = new Thread(thred3);
        list.add(Thread3);

        SpecialThread thred4 = new SpecialThread();
        Thread Thread4 = new Thread(thred4);
        list.add(Thread4);
    }

    public static class SpecialThread implements Runnable
    {
        public void run()
        {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}