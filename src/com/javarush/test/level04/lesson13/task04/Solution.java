package com.javarush.test.level04.lesson13.task04;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int a = 8;
        int b = 0;

        for (; b < 9; b++)
        {
            System.out.print(a);
        }
        for (; b > -2; b--)
        {
            System.out.println(a);
        }

    }
}
