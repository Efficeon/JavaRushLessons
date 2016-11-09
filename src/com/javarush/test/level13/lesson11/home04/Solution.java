package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //читаем из консоли имя файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String namefile = reader.readLine();
        FileWriter file = new FileWriter(namefile, true);

        //пока цикл true вводим строки с консоли и записываем в файл
        //если введено "exit" цикл закрываем
        boolean f = true;
        for (; f = true; )
        {
            String text = reader.readLine();
            if (text.equals("exit"))
            {
                file.write(text);
                file.append('\n');
                f = false;
                break;
            } else
                file.write(text);
            file.append('\n');
        }
        //если введено "exit" выводим содержимое файла на экран
        FileReader read1 = new FileReader(namefile);
        {
            int c;
            while ((c = read1.read()) != -1)
            {
                System.out.print((char) c);
            }
        }
    }
}
