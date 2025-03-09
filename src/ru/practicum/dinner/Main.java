package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap < String ,  ArrayList<Dish>> dishesByType = new HashMap<>(); // < String ,  ArrayList<Dish>>
    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String command = scanner.next();

            switch (command) {
                case "1":
                    System.out.println("Введите тип блюда:");
                    String dishType = scanner.next();
                    System.out.println("Введите название блюда:");
                    String dishName = scanner.next();
                    Dish.addNewDish(dishesByType, dishType, dishName);
                    break;
                case "2":
                    System.out.println("Начинаем конструировать обед...");
                    System.out.println("Введите количество наборов, которые нужно сгенерировать:");
                    int numberOfCombos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
                    String nextItem = scanner.nextLine();
                    ArrayList<String> typesDinner = new ArrayList<>();
                    while (!nextItem.isEmpty()) {
                        if(DinnerConstructor.checkDishType(nextItem, dishesByType)){
                            typesDinner.add(nextItem);
                        }
                        nextItem = scanner.nextLine();
                    }
                    DinnerConstructor.generateDishCombo(dishesByType, numberOfCombos,typesDinner);
                    break;
                case "3":
                    return;


            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }




}
