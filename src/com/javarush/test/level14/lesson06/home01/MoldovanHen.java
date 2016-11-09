package com.javarush.test.level14.lesson06.home01;

/**
 * Created by efficeon on 08.01.16.
 */
public class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 5;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
