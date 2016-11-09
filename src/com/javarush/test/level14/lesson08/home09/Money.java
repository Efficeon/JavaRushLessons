package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double x;

    public Money(double amount)
    {
        x = amount;
    }


    public double getAmount()
    {

        return x;
    }

    public abstract String getCurrencyName();
}

