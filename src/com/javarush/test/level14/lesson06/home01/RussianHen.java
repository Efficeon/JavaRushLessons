package com.javarush.test.level14.lesson06.home01;

/**
 * Created by efficeon on 08.01.16.
 */
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 1;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
