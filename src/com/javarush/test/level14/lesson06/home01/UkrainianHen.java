package com.javarush.test.level14.lesson06.home01;

/**
 * Created by efficeon on 08.01.16.
 */
public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 14;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
