package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1])));

        String line = "";
        while (fileReader.ready()){
            line = fileReader.readLine();
            String[] mass = line.split(" ");
            for (String i : mass){
                if (i.matches(".*\\d.*"))
            fileWriter.write(i+ " ");
            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
