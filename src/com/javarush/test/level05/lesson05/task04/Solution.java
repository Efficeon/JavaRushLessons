package com.javarush.test.level05.lesson05.task04;

package com.javarush.test.level05.lesson05.task01;
//package com.javarush.test.level05.lesson05.task01;
/* Создать три объекта типа Cat
В методе main создать три объекта типа Cat и заполнить их данными.
Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Cat mycat1 = new Cat("ivan", 5, 5, 5);
        Cat mycat2 = new Cat("vasya", 6, 6, 6);
        Cat mycat3 = new Cat("petya", 7, 7, 7);
    }

    public static class Cat
    {

        public static int count = 0;
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength)
        {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
