package com.javarush.test.level29.lesson15.big01.human;

public class Soldier extends Human
{
    protected boolean isSoldier;

    public Soldier(String name, int age, boolean isSoldier)
    {
        super(name, age);
        this.isSoldier = isSoldier;
    }

    public void live() {
        if (isSoldier)
            fight();
    }
    public void fight() {
    }
}

