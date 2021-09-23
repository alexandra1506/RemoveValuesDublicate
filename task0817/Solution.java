package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/*
Нам повторы не нужны

Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.

*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Иван");
        map.put("Федоров", "Дмитрий");
        map.put("Достоевский", "Фёдор");
        map.put("Грозный", "Иван");
        map.put("Пушкин", "Александр");
        map.put("Мураками", "Харуки");
        map.put("Иванова", "Мария");
        map.put("Петрова", "Софья");
        map.put("Сидорова", "Ольга");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, Integer> newMap = new HashMap<>(); //  значение - количество повторений
        for (String v : map.values()){
            if(!newMap.containsKey(v)){
                newMap.put(v, 1);
            }else{
                newMap.put(v, newMap.get(v) +1);
            }
        }
        for (Map.Entry<String, Integer> pair : newMap.entrySet()){
            if(pair.getValue() > 1){
                removeItemFromMapByValue(map, pair.getKey());
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }
}