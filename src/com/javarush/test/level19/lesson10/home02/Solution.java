package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        TreeMap<String, Double> map = new TreeMap<String, Double>();

        String fileName = args[0];
        String name = null;
        double dob = 0;
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(inputStreamReader);

        while (br.ready())
        {
            String[] arr = br.readLine().split(" ");
            name = arr[0];
            dob = Double.parseDouble(arr[1]);
            if(map.containsKey(name))
                dob = dob + map.get(name);
            map.put(name, dob);
        }

        Double max = Double.MIN_VALUE;
        Double value;
        for (String s : map.keySet()) {
            value = map.get(s);
            if (value > max) {
                max = value;
            }
        }

        for (String s1 : map.keySet()) {
            value = map.get(s1);

            if (value == max) {
                System.out.println(s1);
            }
        }
        inputStreamReader.close();
        br.close();
    }
}

