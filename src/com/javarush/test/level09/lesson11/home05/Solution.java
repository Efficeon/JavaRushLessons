package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        List<Character> list1 = new ArrayList<Character>();
        List<Character> list2 = new ArrayList<Character>();

        for (int i = 0; i < line.length(); i++)
        {
            Character x = line.charAt(i);
            if (isVowel(x))
            {
                list1.add(x);
            } else
            {
                if (!isVowel(x) && x != ' ')
                    list2.add(x);
                else
                {
                }
            }
        }
        for (char s : list1)
        {
            System.out.print(s + " ");
        }
        System.out.println(" ");
        for (char s : list2)
        {
            System.out.print(s + " ");
        }

    }

    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква

    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }

}