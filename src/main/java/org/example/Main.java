package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WendingMachine store = new WendingMachine();

        store.addProduct(new Product("Lays", 123.45))
                .addProduct(new Product("fanta", 98.7))
                .addProduct(new Product("cola", 98.7))
                .addProduct(new Product("oreo", 45.5))
                .addProduct(new Product("nuts", 50.2))
                .addProduct(new Product("bounty", 45.5))
                .addProduct((new FastProducts("moloko", 82.0, 5)))
                .addProduct(new Beer("Pivo", 100.0, 6))
                .addProduct(new Bakery("Napoleon",120.0,150.0,5));
        for (Product product : store.getProducts()) {
            System.out.println(product);
        }

        boolean flag = true;
        while(flag){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите действие: 1. Купить 2. Внести позицию 3. Вывести на экран список товаров 4. Найти товар 5. Вывести сумму на экран 6. Выйти");
        String command = sc.nextLine();

        if (command.equals("1")) {
            store.buyMagazine();

        } else if (command.equals("2")) {
            store.addMagazine();
        } else if (command.equals("3")) {
            System.out.println(store);
        }else if (command.equals("4")){
            System.out.println("Введите название для поиска: ");
            String name = sc.nextLine();
            System.out.println(store.findProduct(name));
        }else if (command.equals("5")) {
            System.out.println("Сумма: " + store.getMoney());
        }else if ((command.equals("6"))){
            flag= false;
            System.out.println("Выход");}
        else System.out.println("Не верно введена команда ");
        }


    }
}