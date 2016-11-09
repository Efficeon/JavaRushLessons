package com.javarush.test.level22.lesson05.task02;

import java.util.ArrayList;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        String[]list = string.split("\t");
        if (list.length==0) return "";
        if (list.length<3) throw new TooShortStringException();

        else { string = list[1]; }

        return string;
    }

    public static class TooShortStringException extends RuntimeException { }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
