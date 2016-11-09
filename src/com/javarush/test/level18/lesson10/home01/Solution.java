package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream stream = new FileInputStream(args[0]);
        int i = 0;
        while (stream.available() > 0)
        {
            int j = stream.read();
            if (j >= 65 && j <= 90 || j >= 97 && j <= 122)
                i++;
        }
        System.out.print(i);
        stream.close();
    }
}
