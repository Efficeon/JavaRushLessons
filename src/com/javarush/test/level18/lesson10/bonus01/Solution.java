package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Crypt(args[0], args[1], args[2]);
    }

    public static void Crypt(String argument, String name1, String name2) throws IOException {
        FileInputStream fileName = new FileInputStream(name1);
        FileOutputStream fileOutputName = new FileOutputStream(name2);

        while (fileName.available() > 0) {
            int i = fileName.read();
            if (argument.equals("-e"))
                fileOutputName.write(i + 1);
            if (argument.equals("-d"))
                fileOutputName.write(i - 1);
        }
            fileName.close();
            fileOutputName.close();
    }
}
