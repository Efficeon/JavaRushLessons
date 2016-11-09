package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        FileWriter fileWriter = new FileWriter(reader.readLine());
        String line = null;

        while ((line = bufferedReader.readLine()) != null){
            String[] mass = line.split(" ");
            for (String j : mass)
            {
                boolean bul = true;
                char[] mass1 = new char[j.length()];
                mass1 = j.toCharArray();
                for (Character i : mass1)
                {
                    String v = "1234567890";
                    String x = String.valueOf(i);
                    if (!v.contains(x)){
                        bul = false;}
                }
                if (bul ==true){ fileWriter.write(j+" "); }
            }
        }
        reader.close();
        bufferedReader.close();
        fileWriter.close();
    }
}
