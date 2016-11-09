package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен,
то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //Cat cat1 = new Cat();
    public String name = null;
    public String colour = null;
    public String address = null;
    public int weight = null;
    public int age = null;

    public void initialize(String name="Kuzya")
    {
        this.name = name;
        this.colour = "white";
        this.weight = 3;
        this.address = "street";
    }

    public void initialize(String=name="Tom", int weight=3, int age=4)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.address = "street";
        this.colour = "white";
    }

    public void initialize(String name="Garfild", int age=2)
    {
        this.name = name;
        this.age = age;
        this.address = "street";
        this.colour = "white";

    }

    public void initialize(int weight=4, String colour="grey")
    {
        this.weight = weight;
        this.colour = colour;
        this.address = "street";

    }

    public void initialize(int weight=5, String colour="black", String address="Abrikosova 14")
    {
        this.weight = weight;
        this.colour = colour;
        this.address = address;
    }


    //cat1.name = null;
    //cat1.weight = nell;
    // cat

}
