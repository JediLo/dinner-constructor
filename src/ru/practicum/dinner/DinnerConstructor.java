package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    Random random;
    static HashMap<String, ArrayList<String>> dishesByType;

    public DinnerConstructor() {
        dishesByType = new HashMap<>();
        random = new Random();
    }

    public void generateDishCombo(int numberOfCombos, ArrayList<String> typesDinner) {
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));
            for (String type : typesDinner) {
                ArrayList<String> dishes = dishesByType.get(type);
                System.out.println(dishes.get(random.nextInt(dishes.size())));
            }
        }
    }

    public boolean checkDishType(String typeOfDish) {
        boolean isTypeOfDish = false;
        if (dishesByType.containsKey(typeOfDish)) {
            isTypeOfDish = true;
        } else {
            System.out.println("Тип блюда " + typeOfDish + " не найден. Пожалуйста введите другой тип");
        }
        return isTypeOfDish;
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
