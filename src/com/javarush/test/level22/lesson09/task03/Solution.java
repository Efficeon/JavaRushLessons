package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        StringBuilder text = new StringBuilder();

        while (reader.ready()){ text.append(reader.readLine()+" "); }
        String[] words = text.toString().split(" ");

        reader.close();

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
        bufferedReader.close();
    }

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0) return new StringBuilder();
        if (words[0].equals("") || words.length == 1) return new StringBuilder(words[0]);

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        Collections.addAll(list, words);

        StringBuilder getline = new StringBuilder();
        getline.append(list.get(0));
        list2.add(list.get(0));
        String slovo = list.get(0);
        list.set(0, "");

        boolean triger = true;
        while (triger){
        for (int j=0; j<list.size(); j++){
           if (slovo.equals(list.get(j)) || list.get(j)=="") continue;
                char x = Character.toUpperCase(slovo.charAt(slovo.length()-1));
                char y = Character.toUpperCase(list.get(j).charAt(0));
                if (x==y) {
                    list2.add(list.get(j));
                    slovo=list.get(j);
                    list.set(j, "");
                    j=0;
                }
        }
            if (list2.size() == list.size()) {
                triger = false;
                for (int j=1;j<list.size();j++){
                    getline.append(" ").append(list2.get(j));
                }
            }
            else {
                list.clear();
                Collections.addAll(list, words);
                Collections.shuffle(list);
                list2.clear();
                slovo = list.get(0);
                list2.add(list.get(0));
                list.set(0, "");
                getline = new StringBuilder();
                getline.append(slovo);
            }
        }
        return getline;
     }

}
