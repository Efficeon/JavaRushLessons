package com.javarush.test.level14.lesson08.home06;

/* MovieFactory
Расширение функционала по аналогии, чтение с консоли:
1. Разобраться, что программа умеет делать.
2. Все классы должны быть внутри класса Solution.
3. Добавить классы Cartoon, Thriller.
4. Разобраться, как мы получаем объект класса SoapOpera по ключу "soapOpera".
Аналогично получению объекта SoapOpera сделать:
5. Добавить в MovieFactory.getMovie получение объекта Cartoon для ключа "cartoon".
6. Добавить в MovieFactory.getMovie получение объекта Thriller для ключа "thriller".

7. Считать с консоли несколько ключей (строк).
7.1. Ввод заканчивается, как только вводится строка не совпадающая с одной из: "cartoon", "thriller", "soapOpera".
8. Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1. Получить объект используя MovieFactory.getMovie и присвоить его переменной movie.
8.2. Вывести на экран movie.getClass().getSimpleName().
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        String key = null;

        key = reader.readLine();
        while (true)
        {
            if (key.equals("cartoon"))
            {
                list.add(key);
            } else if (key.equals("thriller"))
            {
                list.add(key);
            } else if (key.equals("soapOpera"))
            {
                list.add(key);
            } else break;
            key = reader.readLine();
        }

        for (String s : list)
        {
            Movie movie = MovieFactory.getMovie(s);
            System.out.println(movie.getClass().getSimpleName());
        }
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory
    {

        static Movie getMovie(String key)
        {
            Movie movie = null;

            if ("soapOpera".equals(key))
            {
                movie = new SoapOpera();
            }
            if ("cartoon".endsWith(key))
            {
                movie = new Cartoon();
            }
            if ("thriller".endsWith(key))
            {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie
    {
    }

    static class SoapOpera extends Movie
    {
    }

    static class Cartoon extends Movie
    {

    }

    static class Thriller extends Movie
    {

    }
}
