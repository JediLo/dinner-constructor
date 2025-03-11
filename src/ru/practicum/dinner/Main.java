package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static DinnerConstructor dinnerConstructor;
    static Scanner scanner;

    public static void main(String[] args) {

        dinnerConstructor = new DinnerConstructor();
        scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String command = scanner.next();
            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Введена неверная команда, попробуйте еще раз");
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.next();
        System.out.println("Введите название блюда:");
        String dishName = scanner.next();
        dinnerConstructor.addNewDish(dishType, dishName);
    }

    public static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> typesDinner = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dinnerConstructor.checkDishType(nextItem)) {
                typesDinner.add(nextItem);
            } else {
                System.out.println("Тип блюда " + nextItem + " не найден. Пожалуйста введите другой тип");
            }
            nextItem = scanner.nextLine();
        }
        dinnerConstructor.generateDishCombo(numberOfCombos, typesDinner);
    }


}
