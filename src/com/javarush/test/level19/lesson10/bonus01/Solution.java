package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileOriginal = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        BufferedReader fileUpdate = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

        ArrayList<String> listOriginal = new ArrayList<String>();
        ArrayList<String> listUpdate = new ArrayList<String>();

        while (fileOriginal.ready()){
            listOriginal.add(fileOriginal.readLine());
        }
        while (fileUpdate.ready()){
            listUpdate.add(fileUpdate.readLine());
        }

        for (int i=0; i<listOriginal.size(); i++){
             if (listOriginal.size()<listUpdate.size()) listOriginal.add("");
             else if (listOriginal.size()>listUpdate.size()) listUpdate.add("");

             if (listOriginal.get(i).equals(listUpdate.get(i))){
                 if(listOriginal.get(i).equals("") && listUpdate.get(i).equals("")) return;
                     lines.add(new LineItem(Type.SAME, listOriginal.get(i)));
               }
             else if (!listOriginal.get(i).equals(listUpdate.get(i))){
                 if (i!=listOriginal.size()-1 && listOriginal.get(i).equals(listUpdate.get(i+1))){
                     listOriginal.add(i, "");
                     lines.add(new LineItem(Type.ADDED, listUpdate.get(i)));
                 }
                 else if (i!=listOriginal.size()-1 && listOriginal.get(i+1).equals(listUpdate.get(i))){
                     listUpdate.add(i, "");
                     lines.add(new LineItem(Type.REMOVED, listOriginal.get(i)));
                 }
                 else if (i==listOriginal.size()-1){
                      if (listOriginal.get(i).equals(""))
                          lines.add(new LineItem(Type.ADDED, listUpdate.get(i)));
                      else if (listUpdate.get(i).equals(""))
                          lines.add(new LineItem(Type.REMOVED, listOriginal.get(i)));
                 }
             }
        }
        reader.close();
        fileOriginal.close();
        fileUpdate.close();
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
