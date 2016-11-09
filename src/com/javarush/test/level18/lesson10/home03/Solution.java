package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileOutputStream fileC = new FileOutputStream(name);
        FileInputStream fileD = new FileInputStream(reader.readLine());
        FileInputStream fileA = new FileInputStream(reader.readLine());

        byte buffer[] = new byte[fileD.available()];
        fileC.write(buffer, 0, fileD.read(buffer));

        fileC = new FileOutputStream(name, true);
        byte buffer1[] = new byte[fileA.available()];
        fileC.write(buffer1, 0, fileA.read(buffer1));

        reader.close();
        fileC.close();
        fileD.close();
        fileA.close();
    }

}
