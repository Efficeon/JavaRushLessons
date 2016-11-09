package com.javarush.test.level15.lesson12.home04;

/**
 * Created by efficeon on 15.01.16.
 */

public class Earth implements Planet

{

    private static Earth instance;

    private Earth()
    {

    }

    public static Earth getInstance()
    {
        if (instance == null)
        {
            return new Earth();
        }
        return instance;
    }

}



