package com.javarush.test.level09.lesson02.task02;
/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода,
вызвавшего его, полученное с помощью StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        method1();
    }

    public static String method1()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String x = stackTraceElements[2].getMethodName();
        return x;
    }

    public static String method2()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String x = stackTraceElements[2].getMethodName();
        return x;
    }

    public static String method3()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String x = stackTraceElements[2].getMethodName();
        return x;
    }

    public static String method4()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String x = stackTraceElements[2].getMethodName();
        return x;
    }

    public static String method5()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String x = stackTraceElements[2].getMethodName();
        return x;
    }
}