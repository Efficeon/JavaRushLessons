package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    public String name = null;
    public String colour = null;
    public int height;

    public void initialize(String name)
    {
        this.name = name;
    }

    public void initialize(String name, int height)
    {
        this.height = height;
        this.name = name;
    }

    public void initialize(String name, String colour, int height)
    {
        this.name = name;
        this.colour = colour;
        this.height = height;
    }

}
