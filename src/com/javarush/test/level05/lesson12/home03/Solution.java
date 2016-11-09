package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Mouse uncleJerry = new Mouse("Fred", 15, 6);
        Mouse cousinJerry = new Mouse("Alfred", 12, 3);

        Cat tomCat = new Cat("Tom", 26, 51);
        Cat uncleTom = new Cat("Dilman", 15, 61);
        Cat cousinTom = new Cat("robert", 45, 31);

        Dog pitDog = new Dog("Pit", 66, 5);
        Dog uncleDog = new Dog("Coc", 58, 6);
        Dog cousinDog = new Dog("Alf", 34, 3);

       /* out.println(jerryMouse.name, jerryMouse.tail, jerryMouse.height);
        out.println(uncleJerry.name, uncleJerry.tail, uncleJerry.height);
        out.println(cousinJerry.name, cousinJerry.tail, cousinJerry.height);

        out.println(tomCat.name, tomCat.tail, tomCat.height);
        out.println(uncleTom.name, uncleTom.tail, uncleTom.height);
        out.println(cousinTom.name, cousinTom.tail, cousinTom.height);

        out.println(pitDog.name, pitDog.tail, pitDog.height);
        out.println(uncleDog.name, uncleDog.tail, uncleDog.height);
        out.println(cousinDog.name, cousinDog.tail, cousinDog.height);*/
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat
    {
        String name;
        int height;
        int tail;

        public Cat(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog
    {
        String name;
        int height;
        int tail;

        public Dog(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

}
