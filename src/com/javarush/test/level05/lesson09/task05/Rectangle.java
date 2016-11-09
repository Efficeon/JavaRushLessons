package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    public int top = 0;
    public int left = 0;
    public int width = 0;
    public int height = 0;

    Rectangle(int top, int left, int width, int height)
    {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    Rectangle(int left, int width)
    {
        this.left = left;
        this.width = width;
    }

    Rectangle(int left, int width, int height)
    {
        this.top = height;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    Rectangle(Rectangle rectangle2)
    {
        this.top = rectangle2.top;
        this.left = rectangle2.left;
        this.width = rectangle2.width;
        this.height = rectangle2.height;
    }

}
