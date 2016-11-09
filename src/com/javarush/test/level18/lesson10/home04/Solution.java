package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String fileName2 = reader.readLine();

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        FileInputStream file2 = new FileInputStream(fileName2);

        List<String> list = new ArrayList<String>();

        String line;
        while ((line = reader1.readLine()) != null)
        {
            list.add(line);
        }
        reader1.close();

        FileOutputStream file1 = new FileOutputStream(fileName);
        byte[] buffer = new byte[file2.available()];
        file1.write(buffer, 0, file2.read(buffer));

        file1.close();
        file2.close();

        FileWriter file = new FileWriter(fileName, true);
        for (String i : list)
        {
            file.write(i + "\n");
        }
        file.close();
        reader.close();
    }
}
