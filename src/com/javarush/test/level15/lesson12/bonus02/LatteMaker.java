package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by efficeon on 16.01.16.
 */
public class LatteMaker extends DrinkMaker
{
    void getRightCup()
    {
        System.out.println("Берем чашку для латте");
    }

    void putIngredient()
    {
        System.out.println("Делаем кофе");
    }

    void pour()
    {
        System.out.println("Заливаем молоком с пенкой");
    }

    public void makeDrink()
    {
        super.makeDrink();
    }
}

