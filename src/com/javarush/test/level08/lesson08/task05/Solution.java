package com.javarush.test.level08.lesson08.task05;

//import com.sun.javafx.collections.MappingChange;
//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    /* public static void main(String[] args)
     {
         HashMap<String , String> map = createMap();
         removeTheFirstNameDuplicates(map);
         for(Map.Entry<String, String> pair5 : map.entrySet()) {
             System.out.println(pair5.getKey() + " - " + pair5.getValue());;
         }
     }*/
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Dubravsky", "Leonid");
        map.put("Burdeyna", "Nadiya");
        map.put("Verhov", "Aleksandr");
        map.put("Borozenec", "Aleksandr");
        map.put("Poberezhnik", "Dmitriy");
        map.put("Cherna", "Masha");
        map.put("Podoprygora", "Taras");
        map.put("Ostapenko", "Aleksandr");
        map.put("Domidenko", "Igor");
        map.put("Grinka", "Vasiliy");

        return (HashMap<String, String>) map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        Map<String, String> map1 = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair2 : map1.entrySet())
        {

            int i = 0;
            for (Map.Entry<String, String> pair1 : map1.entrySet())
            {
                if (pair2.getValue().equals(pair1.getValue()))
                {
                    i++;
                }
                if (i > 1)
                {
                    removeItemFromMapByValue(map, pair2.getValue());
                }
            }

        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
