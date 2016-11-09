package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));

        StringBuilder line = new StringBuilder();
        while (reader.ready()) {
         line.append(reader.readLine()+ " ");
        }
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, line.toString().split(" "));

        bufferedReader.close();
        reader.close();

        StringBuilder newLine = null;
        for (int i=0;i<list.size();i++){
            if (list.get(i).equals("")) continue;
            for (int j=1;j<list.size();j++){
                newLine = new StringBuilder(list.get(j).subSequence(0, list.get(j).length()));
                if (list.get(i).equals(newLine.reverse().toString()) && i!=j)
                {
                    Pair pair = new Pair();
                    pair.first = newLine.toString();
                    pair.second = newLine.reverse().toString();
                    result.add(pair);
                    list.set(i, "");
                    list.set(j, "");
                    break;
                }
            }
        }
        for (Pair p : result) {
            System.out.println(p.first+ " "+p.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
