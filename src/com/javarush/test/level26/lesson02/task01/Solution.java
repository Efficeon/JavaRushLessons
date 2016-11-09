package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int i_middle = array.length/2;
        final double mediana = (array.length % 2 == 1) ? array[i_middle] : (array[i_middle - 1] + array[i_middle]) / 2;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result =  (int)Math.round(Math.abs(mediana - o1) - Math.abs(mediana - o2));
                return (result == 0) ? (o1 - o2) : result;
            }
        };

        Arrays.sort(array, comparator);

        return array;
    }
}
