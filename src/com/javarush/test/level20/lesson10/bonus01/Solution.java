package com.javarush.test.level20.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
//    public static void main(String args[]) throws IOException
//    {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(reader.readLine());
//        int[] mass = getNumbers(N);
//        for (int j : mass)
//        {
//            System.out.println(j);
//        }
//        Long t1 = System.currentTimeMillis();
//        Long t0 = System.currentTimeMillis();
//        long n = 100000000;
//
//        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
//        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
//    }

    public static int[] getNumbers(int N)
    {
        int[] result = null;
        ArrayList<Integer> set = new ArrayList<Integer>();
        double[][] matrix = new double[10][10];
        for (int d = 0; d < 10; d++){
            for (int j = 0; j < 10; j++) { matrix[d][j] = Math.pow(d, j);}
        }
        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> list7 = new ArrayList<Integer>();
            int M = i;
            int yy = 0;
            for (int l = 0; M > 0; M /= 10) {
                list7.add(0, M % 10);
                yy++;
            }

            //boolean link = true;
            int r = 0;

            if (list7.size() >= 2){
              for (int t = 0; t < list7.size(); t++)   { r += matrix[list7.get(t)][list7.size()];}
                if (r == i) set.add(r);
            } else set.add(i);
        }

            result = new int[set.size()];
            for (int h = 0; h < result.length; h++){
                result[h] = set.get(h);
            }

        return result;
    }
}
