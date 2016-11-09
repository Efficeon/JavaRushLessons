package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1])));

        String str = "";
        while (bufferedReader.ready()){
            String[] line = bufferedReader.readLine().split(" ");
            for (int i=0; i<line.length; i++){
                if(line[i].length()>6){
                str +=line[i]+",";
                }
            }
        }
        str = str.substring(0,str.length()-1);
        bufferedWriter.write(str);
        bufferedReader.close();
        bufferedWriter.close();
    }
}
