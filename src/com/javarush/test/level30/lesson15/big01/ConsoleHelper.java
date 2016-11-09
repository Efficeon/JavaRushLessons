package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** вспомогательный класс, для чтения или записи в консоль */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**должен выводить сообщение message в консоль*/
    public static void writeMessage(String message){
        System.out.println(message);
    }

    /**должен считывать строку с консоли*/
    public static String readString(){
        String line = null;
        while (line == null)
            try { line = reader.readLine();}
            catch (IOException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        return line;
    }

    /**должен возвращать введенное число и использовать*/
    public static int readInt(){

        int number = 0;
        while (true)
            try {
                number = Integer.parseInt(readString());
                break;
            }
            catch (NumberFormatException e) {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        return number;
    }
}
