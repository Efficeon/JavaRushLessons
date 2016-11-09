package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
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

        while (br.ready()){
            String[] arr = br.readLine().split(" ");
            name = arr[0];
            dob = Double.parseDouble(arr[1]);
            if(map.containsKey(name))
                dob = dob + map.get(name);
            map.put(name, dob);
        }
        inputStreamReader.close();
        br.close();
        for(Map.Entry<String, Double> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
        inputStreamReader.close();
        br.close();
    }
}
