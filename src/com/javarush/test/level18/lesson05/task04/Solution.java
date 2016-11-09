package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            FileInputStream file1 = new FileInputStream(reader.readLine());
            FileOutputStream file2 = new FileOutputStream(reader.readLine());

            byte[] buffer = new byte[file1.available()];
            file1.read(buffer);
            byte[] buffer2 = new byte[buffer.length];
            for (int i = 0; i < buffer.length; i++)
            {
                buffer2[i] = buffer[buffer.length - i - 1];
            }
            file2.write(buffer2);
            reader.close();
            file1.close();
            file2.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
