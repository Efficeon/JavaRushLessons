package com.javarush.test.level09.lesson11.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        readData();
    }

    public static void readData()
    {
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            while (true)
            {

                listInt.add(Integer.parseInt(reader.readLine()));
            }
        }
        catch (Exception e)
        {
            for (Integer i : listInt) System.out.println(i);
        }
    }
}