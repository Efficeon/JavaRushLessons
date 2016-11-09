package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/* Добавление файла в архив
В метод main приходит список аргументов. Первый аргумент - полный путь к файлу fileName.Второй аргумент -
путь к zip-архиву. Добавить файл (fileName) внутрь архива в директорию 'new'.Если в архиве есть файл с таким
именем, то заменить его.

Пример входных данных:   C:/result.mp3   C:/pathToTest/test.zip

Файлы внутри test.zip:  a.txt    b.txt
После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3   a.txt   b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,а потом записать в архив все энтри вместе с
добавленным файлом.Пользоваться файловой системой нельзя.
*/
public class Solution {

    static ArrayList<ZipEntry> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        if (args.length != 2) return;

        File newFile = new File(args[0]);
        File zipFile = new File(args[1]);

        extFile(zipFile);
        addListFile(newFile, zipFile);
    }

    public static void extFile(File zipFile){
      try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile)))
        {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null){
                list.add(entry);
            }
            zipInputStream.close();
        }
      catch (IOException e)  {e.printStackTrace();}
    }

    public static void addListFile(File newFile, File zipFile){
      try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
          FileInputStream fileInputStream = new FileInputStream(newFile)){
          ZipEntry newZipEntry = new ZipEntry(newFile.getName());

          boolean yesNo = false;
          for (ZipEntry entry : list)
          {
              if (!entry.getName().equals(newZipEntry.getName()))
              {
                  byte[] buffer = new byte[fileInputStream.available()];
                  zipOutputStream.putNextEntry(new ZipEntry(entry.getName()));
                  zipOutputStream.write(buffer);
              } else
              {
                  yesNo = true;
              }
          }

             byte[] buffer = new byte[fileInputStream.available()];
             ZipEntry zipEntry;

              if (yesNo){
                  zipEntry = new ZipEntry("new/" + newFile.getName());
              }
              else {
                  zipEntry = new ZipEntry(newFile.getName());
              }
          zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getName()));
          zipOutputStream.write(buffer);
          zipOutputStream.closeEntry();

         zipOutputStream.close();
         fileInputStream.close();
      }
      catch (Exception e){e.printStackTrace();}
    }
}
