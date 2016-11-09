package com.javarush.test.level22.lesson09.task02;

import java.util.*;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {

            StringBuilder string = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    if (string.toString().equals(""))
                        string.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                    else
                        string.append(" and ").append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                }
        }
        return string;
    }
}
