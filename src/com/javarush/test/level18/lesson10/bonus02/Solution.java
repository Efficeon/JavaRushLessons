package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/


import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        BufferedWriter baseFile = new BufferedWriter(new FileWriter(name, true));
        baseFile.newLine();
        baseFile.write(String.format("%-8.8s%-30.30s%-8.8s%-4.4s", (IDdefine(name)+1), args[1], args[2], args[3]));
        reader.close();
        baseFile.close();

    }
    public static int IDdefine(String name) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        String line = null;
        while ((line = reader1.readLine()) != null){
            line = line.substring(0, 8);
            line = line.replace(" ","");
            treeSet.add(Integer.parseInt(line));
        }
        reader1.close();
        return treeSet.last();
    }
}
