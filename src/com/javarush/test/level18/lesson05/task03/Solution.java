package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        try
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            FileInputStream fileC = new FileInputStream(reader.readLine());
            FileOutputStream fileD = new FileOutputStream(reader.readLine());
            FileOutputStream fileA = new FileOutputStream(reader.readLine());


            int size2 = fileC.available() / 2;
            int size1 = fileC.available() - size2;


            byte[] buffer = new byte[size1];
            byte[] buffer2 = new byte[size2];
            fileD.write(buffer, 0, fileC.read(buffer));
            fileA.write(buffer2, 0, fileC.read(buffer2));

            reader.close();
            fileC.close();
            fileD.close();
            fileA.close();
        }
        catch (IOException e)
        {
        }
    }
}
