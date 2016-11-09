package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream filePatr;
        FileOutputStream newFileOut;
        TreeSet<String> setFile = new TreeSet<String>();

        String name = reader.readLine();
        String newFile = null;
        while (!name.equals("end")){
            setFile.add(name);
            newFile = name;
            name = reader.readLine();
        }

        int dot = newFile.lastIndexOf(".");
        newFile = newFile.substring(0, dot);
        File fileNew = new File(newFile);

        for (String e : setFile) {
            filePatr = new FileInputStream(e);
            newFileOut = new FileOutputStream(fileNew, true);
            byte[] buffered = new byte[filePatr.available()];
            newFileOut.write(buffered, 0, filePatr.read(buffered));
            filePatr.close();
            newFileOut.close();
        }
        reader.close();
    }
}
