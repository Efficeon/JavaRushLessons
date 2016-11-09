package com.javarush.test.level27.lesson15.big01.ad;

import java.util.TreeMap;

public class StatisticAdvertisementManager {
    private static final StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    public TreeMap<String, Integer> getActivVideo(){
        TreeMap<String, Integer> rezult = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement a:storage.list()){
            if (a.getHits()>=1){
                rezult.put(a.getName(),a.getHits());
            }
        }
        return rezult;


    }
    public TreeMap<String, Integer> getArchivVideo(){
        TreeMap<String, Integer> rezult = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement a:storage.list()){
            if (a.getHits()<1){
                rezult.put(a.getName(),a.getHits());
            }
        }
        return rezult;
    }
}
