package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {

        if (args[0].equals("-c"))
        {
            for (int i = 1; i <= args.length - 1; i = i + 3)
            {
                create(args[i], args[i + 1], args[i + 2]);
            }
        }

        if (args[0].equals("-u"))
        {
            for (int i = 1; i <= args.length - 1; i = i + 4)
            {
                update(args[i], args[i + 1], args[i + 2], args[i + 3]);
            }
        }

        if (args[0].equals("-d"))
        {
            for (int i = 1; i <= args.length - 1; i++)
            {
                delete(args[i]);
            }
        }

        if (args[0].equals("-i"))
        {
            for (int i = 1; i <= args.length - 1; i++)
            {
                information(args[i]);
            }
        }
    }

    public static synchronized void create(String name, String sex, String birthday)
    {
        SimpleDateFormat formatDate1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try
        {
            if (sex.equals("м"))
                allPeople.add(Person.createMale(name, formatDate1.parse(birthday)));
            else
                allPeople.add(Person.createFemale(name, formatDate1.parse(birthday)));
            System.out.println(allPeople.size() - 1);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public static synchronized void update(String id, String name, String sex, String birthday)
    {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person = allPeople.get(Integer.parseInt(id));
        try
        {
            person.setName(name);
            person.setBirthDay(formatDate.parse(birthday));
            if (sex.equals("м"))
                person.setSex(Sex.MALE);
            else
                person.setSex(Sex.FEMALE);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public static synchronized void delete(String id)
    {
        Person person = allPeople.get(Integer.parseInt(id));
        try
        {
            person.setBirthDay(null);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void information(String id)
    {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = allPeople.get(Integer.parseInt(id));
        try
        {
            String s;
            if (person.getSex().equals(Sex.MALE))
                s = "м";
            else
                s = "ж";
            System.out.println(person.getName() + " " + s + " " + formatDate.format(person.getBirthDay()));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
