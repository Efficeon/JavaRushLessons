package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/** будет хранить всю информацию про выбранную валюту. */
public class CurrencyManipulator
{
    /**код валюты, например, USD. Состоит из трех букв*/
    private String currencyCode;

    /**это Map<номинал, количество>*/
    private Map<Integer, Integer> denominations = new HashMap<>();

    public boolean isAmountAvailable(int expectedAmount)
    {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            list.add(pair.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (Integer aList : list) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());

            denominations.clear();
            denominations.putAll(temp);
            ConsoleHelper.writeMessage("Транзакция проведена успешно!");
        }
        return result;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    /**Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode*/
    public String getCurrencyCode()
    {
        return currencyCode;
    }

    /**добавит введенные номинал и количество банкнот*/
    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);
    }

    /**посчитает общую сумму денег для выбранной валюты.*/
    public int getTotalAmount(){
        int result = 0;
        for(Map.Entry<Integer,Integer> pair : denominations.entrySet())
            result = result + (pair.getKey() * pair.getValue());
        return result;
    }

    public boolean hasMoney(){
        return denominations.size() != 0;
    }
}