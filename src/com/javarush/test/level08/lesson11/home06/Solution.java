package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(new Human("Katya", false, 16));
        children.add(new Human("Kolya", true, 10));
        children.add(new Human("Ira", false, 5));

        ArrayList<Human> parents1 = new ArrayList<Human>();
        parents1.add(new Human("Vitya", true, 45, children));
        ArrayList<Human> parents2 = new ArrayList<Human>();
        parents2.add(new Human("Gala", true, 38, children));

        ArrayList<Human> grandParents1 = new ArrayList<Human>();
        grandParents1.add(new Human("Tofa", true, 65, parents1));
        grandParents1.add(new Human("Anna", false, 65, parents1));

        ArrayList<Human> grandParents2 = new ArrayList<Human>();
        grandParents2.add(new Human("Tofa", true, 67, parents2));
        grandParents2.add(new Human("Nina", false, 57, parents2));

        System.out.println(children);
        System.out.println(parents1);
        System.out.println(parents2);
        System.out.println(grandParents1);
        System.out.println(grandParents2);


    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
