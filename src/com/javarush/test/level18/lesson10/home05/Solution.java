package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

        String line;
        while ((line = reader1.readLine()) != null)
        {
            String[] array = line.split(" ");
            for (String i : array)
            {
                long num = Math.round(Double.parseDouble(i));
                String x = num + " ";
                fileOutputStream.write((num + " ").getBytes());
            }
        }
        reader.close();
        reader1.close();
        fileOutputStream.close();
    }
}
