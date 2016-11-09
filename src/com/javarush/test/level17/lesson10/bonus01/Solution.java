package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);

        if (args.length == 4 && args[0].equals("-c"))
        {
            try
            {
                if (args[2].equals("м"))
                {
                    allPeople.add(Person.createMale(args[1], format.parse(args[3])));
                } else
                {
                    allPeople.add(Person.createFemale(args[1], format.parse(args[3])));
                }
                System.out.println(allPeople.size() - 1);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        if (args.length == 5 && args[0].equals("-u"))
        {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            try
            {
                person.setName(args[2]);
                person.setBirthDay(format.parse(args[4]));

                if (args[3].equals("м"))
                {
                    person.setSex(Sex.MALE);
                } else
                {
                    person.setSex(Sex.FEMALE);
                }
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        if (args.length == 2 && args[0].equals("-d"))
        {
            try
            {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setBirthDay(null);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if (args.length == 2 && args[0].equals("-i"))
        {
            try
            {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                String s;
                if (person.getSex().equals(Sex.MALE))
                    s = "м";
                else
                    s = "ж";
                System.out.println(person.getName() + " " + s + " " + format2.format(person.getBirthDay()));


            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        }
    }
}

