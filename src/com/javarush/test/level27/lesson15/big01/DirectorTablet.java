package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    public void printAdvertisementProfit(){
        double total = 0;
        for (Map.Entry<Date, Double> entry : StatisticEventManager.getInstance().getAdvProfit().entrySet())
        {
            total += entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", simpleDateFormat.format(entry.getKey()), entry.getValue()));
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f",total));
    }



    public void printCookWorkloading(){
        for (Map.Entry<Date, TreeMap<String, Integer>> pair : StatisticEventManager.getInstance().getCookWorkTime().entrySet()) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(pair.getKey()));
            for (Map.Entry<String, Integer> pair2 : pair.getValue().entrySet()) {
                if (pair2.getValue() > 0) {
                    ConsoleHelper.writeMessage(String.format("%s - %d min", pair2.getKey(), pair2.getValue()));
                }
            }
        }

    }

    public void printActiveVideoSet(){
        for (Map.Entry a: StatisticAdvertisementManager.getInstance().getActivVideo().entrySet()){
            ConsoleHelper.writeMessage(String.format("%s - %d",a.getKey(),a.getValue()));

        }

    }

    public void printArchivedVideoSet(){
        for (Map.Entry a: StatisticAdvertisementManager.getInstance().getArchivVideo().entrySet()){
            ConsoleHelper.writeMessage(String.format("%s",a.getKey()));

        }

    }
}