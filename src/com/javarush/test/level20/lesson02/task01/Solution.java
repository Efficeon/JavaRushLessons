package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем
        // к вашему реальному файлу

        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/home/lion/java/test/test1.txt");
            InputStream inputStream = new FileInputStream("/home/lion/java/test/test1.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);


            if (ivanov.equals(somePerson))
                System.out.println("true");
            inputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(name);
            for (Asset asset : assets){
                printWriter.println(asset.getName());
                printWriter.println(asset.getPrice());
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            name = bufferedReader.readLine();
            while (bufferedReader.ready()){
                String name = bufferedReader.readLine();
                if (name.isEmpty()) name = "Guest";
                assets.add(new Asset(name));
                assets.get(assets.size()-1).setPrice(Double.parseDouble(bufferedReader.readLine()));
            }
            bufferedReader.close();
        }
        public boolean equals(Object obj){
            if (obj==this) return true;
            if (obj==null) return false;
            if (!(getClass() == obj.getClass())) return false;
            else{
                if(name == this.name) return true;
                else
                    return  false;
            }
        }
    }
}
