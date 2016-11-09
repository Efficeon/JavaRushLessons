package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties proper = new Properties();

    public void fillInPropertiesMap() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        load(inputStream);

        reader.close();
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        if (proper.size()>0){
            proper.putAll(properties);
            proper.store(outputStream, ":");
        }
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        proper.load(inputStream);
        Set<String> line = proper.stringPropertyNames();
        for (String s : line){
            properties.put(s, proper.getProperty(s));
    }
        bufferedReader.close();
    }
}
