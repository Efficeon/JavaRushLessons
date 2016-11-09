package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRead = new BufferedReader(new FileReader(reader.readLine()));
        FileWriter fileWrit = new FileWriter(reader.readLine());

        String line;
        while ((line = fileRead.readLine()) != null){
           line = line.replace(".", "!");
           fileWrit.write(line+ "\n");

        }
        reader.close();
        fileRead.close();
        fileWrit.close();
    }
}
