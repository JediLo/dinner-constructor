package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;


public class Dish {
    String name;

    public Dish(String name) {
        this.name = name;
    }

    static void addNewDish(HashMap< String , ArrayList<Dish>> dishesByType,String dishType, String dishName) {
        Dish dishNew = new Dish(dishName);
        if(dishesByType.containsKey(dishType)){
            dishesByType.get(dishType).add(dishNew);
        } else {
            ArrayList<Dish> dishes = new ArrayList<>();
            dishes.add(dishNew);
            dishesByType.put(dishType, dishes);
        }
    }
}
