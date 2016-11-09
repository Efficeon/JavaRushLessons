package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] array = new Integer[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(array, Collections.reverseOrder());
        //sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        //Arrays.sort(array, Collections.reverseOrder());
        /*for(int i=0; i<array.length-1; i++){
         for(int j=i+1; j<array.length; j++){
             if(array[i]<array[j])
             {
                 int temp=array[i];
                 array[i] = array[j];
                 array[j] = temp;
             }

         }

        }*/
    }
}
