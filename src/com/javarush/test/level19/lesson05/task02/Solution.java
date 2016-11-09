package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        String line = null;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null){
            line=line.replaceAll("\\p{Punct}"," ");
            String[] mass = line.split(" ");
            for (String line1 : mass){
                if (line1.equals("world")){
                    i++;
                }
            }
        }
        System.out.print(i);
        reader.close();
        bufferedReader.close();
    }
}
