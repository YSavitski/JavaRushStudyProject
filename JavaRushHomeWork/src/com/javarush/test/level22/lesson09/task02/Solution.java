package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

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
        StringBuilder resultBulted = new StringBuilder();
        int counter = 0;

        for (Map.Entry<String, String> param:
             params.entrySet()) {
            if(param.getValue() != null){
                if(counter != 0){
                    resultBulted.append(" and ");
                    resultBulted.append(String.format("%s = \'%s\'", param.getKey(), param.getValue()));
                }
                else{
                    resultBulted.append(String.format("%s = \'%s\'", param.getKey(), param.getValue()));
                }
                counter++;
            }
        }
        return resultBulted;
    }
}
