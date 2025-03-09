package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {



     static void generateDishCombo(HashMap<String, ArrayList<Dish>> dishesByType ,int numberOfCombos, ArrayList<String> typesDinner) {
         Random random = new Random();

         for (int i = 0; i < numberOfCombos; i++) {
             System.out.println("Комбо " + (i+1) );
             for (String type : typesDinner) {
                 ArrayList<Dish> dishes = dishesByType.get(type);
                 System.out.println(dishes.get(random.nextInt(dishes.size())).name);
             }
         }
     }

    public static boolean checkDishType(String typeOfDish ,HashMap<String, ArrayList<Dish>> dishesByType) {
         boolean isTypeOfDish = false;
         if(dishesByType.containsKey(typeOfDish)){
             isTypeOfDish = true;
         } else {
             System.out.println("Тип блюда " + typeOfDish + " не найден. Пожалуйста введите другой тип");
         }
         return isTypeOfDish;
    }
}
