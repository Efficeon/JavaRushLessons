package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

        String line;
        while(fileReader.ready()) {
            line = fileReader.readLine();
            String[] mass = line.split(" ");
            int a = 0;

            for (String j : words){
                for (String i : mass){
                 if (i.contains(j))
                     a++;
                }
            }
            if (a==2)
                System.out.println(line);
         }

        reader.close();
        fileReader.close();
    }
}












