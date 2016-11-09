package com.javarush.test.level18.lesson10.home08;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (!line.equals("exit")){
           ReadThread readThread = new ReadThread(line);
           readThread.start();
           line = reader.readLine();
           }
         for (Map.Entry e : resultMap.entrySet()){
           System.out.println(e.getKey()+ " " +e.getValue());
         }
    }

    public static class ReadThread extends Thread
    {
        String fileName;
        public ReadThread(String fileName) { this.fileName = fileName; }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            try {
                ArrayList<Integer> list = new ArrayList<Integer>();
                TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
                FileInputStream file = new FileInputStream(this.fileName);

                while (file.available() > 0) { list.add(file.read()); }

                for (int i : list) {
                    int x = 0;
                    for (int j : list) { if (j==i) x++; }
                    map.put(i, x);
                }

                int v =0;
                int t = 0;
                for (Map.Entry e : map.entrySet()) {
                    if ((int) e.getValue() > t) {
                        t = (int) e.getValue();
                        v = (int) e.getKey();
                    }
                    AddMap(this.fileName, v);
                }
                file.close();
            }
            catch (IOException e) {e.printStackTrace() ;}
        }
        public synchronized void AddMap(String fileName, int v){
           resultMap.put(fileName, v);
        }
    }
}
