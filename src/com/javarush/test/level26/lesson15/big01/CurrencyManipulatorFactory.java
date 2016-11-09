package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;

import java.util.Collection;

/** Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы. */
public final class CurrencyManipulatorFactory
{
    static HashMap<String, CurrencyManipulator> map = new HashMap<>();
    static boolean isExist = false;

    /**В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.*/
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        isExist = false;
        CurrencyManipulator current;

        if (map.containsKey(currencyCode))
            return map.get(currencyCode);
        else {
            current = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, current);
            return current;
        }
    }

    private CurrencyManipulatorFactory()
    {
    }

    /**вернет Collection всех манипуляторов.*/
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return map.values();
    }

 }