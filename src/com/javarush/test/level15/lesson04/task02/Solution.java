package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution
{
    public static void main(String[] args)
    {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value)
    {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(value);
            }
            System.out.println();
        }
        printMatrix((short) m, n, (Object) value);
    }

    public static void printMatrix(short m, int n, Object value)
    {
        System.out.println("Заполняем объектами 3");
        printMatrix(m, (short) n, value);
    }

    public static void printMatrix(short m, short n, Object value)
    {
        System.out.println("Заполняем объектами 4");
        printMatrix((byte) m, n, value);
    }

    public static void printMatrix(byte m, short n, Object value)
    {
        System.out.println("Заполняем объектами 5");
        printMatrix(m, (byte) n, value);
    }

    public static void printMatrix(byte m, byte n, Object value)
    {
        System.out.println("Заполняем объектами 6");
        printMatrix((long) m, (short) n, value);
    }

    public static void printMatrix(long m, short n, Object value)
    {
        System.out.println("Заполняем объектами 7");
        printMatrix(m, (long) n, value);
    }

    public static void printMatrix(long m, long n, Object value)
    {
        System.out.println("Заполняем объектами 8");
        printMatrix((Long) m, n, value);
    }

    public static void printMatrix(Long m, long n, Object value)
    {
        System.out.println("Заполняем объектами 9");
        printMatrix(m, (Long) n, value);
    }

    public static void printMatrix(Long m, Long n, Object value)
    {
        System.out.println("Заполняем объектами 10");
    }
}
