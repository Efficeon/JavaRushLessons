package com.javarush.test.level03.lesson12.home03;

/* Я буду зарабатывать $50 в час
Ввести с клавиатуры число n.
Вывести на экран надпись «Я буду зарабатывать $n в час».
Пример:
Я буду зарабатывать $50 в час
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String salary = reader.readLine();
        int isalary = Integer.parseInt(salary);
        System.out.print("Я буду зарабатывать $" + salary + " в час");
    }
}