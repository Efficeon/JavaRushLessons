package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private static String name;
        private static String lastname;
        private static String sex;
        private static int age;
        private static int height;
        private static int weight;

        Human(String name, String lastname, String sex, int age, int height, int weight)
        {
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        Human(String name, String lastname)
        {
            this.name = name;
            this.lastname = lastname;
        }

        Human(String name, String lastname, String sex)
        {
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
        }

        Human(String name, String lastname, String sex, int age)
        {
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, String lastname, String sex, int age, int height)
        {
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
            this.age = age;
            this.height = height;
        }

        Human(String name, String lastname, int age, int weight)
        {
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.weight = weight;
        }

        Human(String lastname, String sex, int age, int height, int weight)
        {
            this.lastname = lastname;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        Human(String name)
        {
            this.name = name;
        }

        Human(String sex, int age, int height, int weight)
        {
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        Human(int age, int height, int weight)
        {
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
    }
}
