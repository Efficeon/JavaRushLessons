package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by efficeon on 09.01.16.
 */
public class Singleton
{
    private static Singleton instance = new Singleton();

    private Singleton()
    {
    }

    public static Singleton getInstance()
    {
        return instance;
    }
}
