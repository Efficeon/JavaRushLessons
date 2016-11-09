package com.javarush.test.level04.lesson13.task01;

/* Четные числа
Используя цикл for вывести на экран чётные числа от 1 до 100 включительно.
Через пробел либо с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int b = 1;

        for (b++; b <= 101; b = b + 2)
        {
            System.out.print(b);
        }

    }
}
