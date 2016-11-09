package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        File root1 = new File(root);
        List<String> list = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();

        Collections.addAll(queue, root1.listFiles());

        while (!queue.isEmpty()){
            File file = queue.remove();
            if (file.isDirectory())
                Collections.addAll(queue, file.listFiles());
            else
                list.add(file.getAbsolutePath());
        }

        return list;
    }
}
