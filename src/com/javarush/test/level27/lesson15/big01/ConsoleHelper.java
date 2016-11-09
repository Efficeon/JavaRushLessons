package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);

    }
    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> result = new ArrayList<>();
        Dish[] dishs = Dish.values();
        ConsoleHelper.writeMessage("Choose dish: " +Dish.allDishesToString() +" or \"EXIT\"");
        boolean doo = true;
        while (doo){
            String choose = readString();
            if(choose.toLowerCase().equals("exit")) {
                doo = false;
                break;
            }
            boolean flag = false;
            for (Dish d:Dish.values()){
                if(d.toString().equals(choose)){
                    result.add(d);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                ConsoleHelper.writeMessage(choose+"is not detected");
            }
        }
        return result;
    }
}
