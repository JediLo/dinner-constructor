package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>> dishesByType = new HashMap<>();

    public void generateDishCombo(int numberOfCombos, ArrayList<String> typesDinner) {

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> dishes = new ArrayList<>();
            System.out.println("Комбо " + (i + 1));
            for (String type : typesDinner) {
                ArrayList<String> dishThisType =  dishesByType.get(type);
                dishes.add(dishThisType.get(random.nextInt(dishThisType.size())));
            }
            System.out.println(dishes);
        }
    }

    public boolean checkDishType(String typeOfDish) {
        return dishesByType.containsKey(typeOfDish);
    }

    public void addNewDish(String dishType, String dishName) {
        if (dishesByType.containsKey(dishType)) {
            dishesByType.get(dishType).add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesByType.put(dishType, dishes);
        }
    }
}
