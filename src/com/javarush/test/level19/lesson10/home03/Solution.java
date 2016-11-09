package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws ParseException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

        while (reader.ready()){
          String[]line =reader.readLine().split(" ");
            String name = "";
            Date date = new Date(Integer.parseInt(line[line.length-1]),
                                 Integer.parseInt(line[line.length-2])-1,
                                 Integer.parseInt(line[line.length- 3]));
            for (int i = 0; i < line.length - 3; i++) {
                if (i==(line.length - 4)) {name += line[i];}
            else
                name += line[i] + " ";
            }
              PEOPLE.add(new Person(name, date));
        }
        reader.close();
   }
}
