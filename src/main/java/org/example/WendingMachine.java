package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WendingMachine {

    public double getMoney() {
        return money;
    }

    private double money =0;
    private List<Product> products = new ArrayList<>();

    public WendingMachine addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }
    public Product findProduct(String name){
        for (Product product : getProducts()) {
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
    public Product buy(String name,double price){
        Product myProduct = findProduct(name);
        if (myProduct==null) return null;
        if (myProduct.getPrice()==price) {
            products.remove(myProduct);
            money+=myProduct.getPrice();
            return myProduct;

        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder wdProducts = new StringBuilder();
        for (Product prod:this.getProducts()) {
            wdProducts.append(prod.toString())
                    .append("\n");

            }
        wdProducts.append(money);
        return wdProducts.toString();
    }
    public void buyMagazine(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название товара: ");
        String nextCommand = sc.nextLine();

        System.out.println("Внесите сумму: ");
        double ourPrice;
        ourPrice = Double.parseDouble(sc.next());

        System.out.println(buy(nextCommand, ourPrice) + "Продан");
    }
    public void addMagazine(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберете категорию продукта: 1. Обычные продукты. 2. Продукт с коротким сроком хранения. 3. Алкогольная продукция 4. Выпечка: ");
        String nextCommand = sc.nextLine();
        if (nextCommand.equals("1")) {
            System.out.println("Введите название:");
            String name = sc.nextLine();
            System.out.println("Укажите стоимость");
            double price = Double.parseDouble(sc.next());
            addProduct(new Product(name,price));
            System.out.println(findProduct(name) + "Добавлен в список!");
        } else if (nextCommand.equals("2")) {
            System.out.println("Введите название:");
            String name = sc.nextLine();
            System.out.println("Укажите стоимость");
            double price = Double.parseDouble(sc.next());
            System.out.println("Укажите срок годности");
            int longivety = sc.nextInt();
            addProduct(new FastProducts(name,  price,longivety));
            System.out.println(findProduct(name) + "Добавлен в список!");
        } else if (nextCommand.equals("3")) {
            System.out.println("Введите название:");
            String name = sc.nextLine();
            System.out.println("Укажите стоимость");
            double price = Double.parseDouble(sc.next());
            System.out.println("Укажите содержание алкоголя");
            int alcogol = sc.nextInt();
            addProduct(new Beer(name, price, alcogol));
            System.out.println(findProduct(name) + "Добавлен в список!");
        } else if (nextCommand.equals("4")) {
            System.out.println("Введите название:");
            String name = sc.nextLine();
            System.out.println("Укажите стоимость");
            double price = Double.parseDouble(sc.next());
            System.out.println("Укажите вес изделия");
            double weight = Double.parseDouble(sc.next());
            System.out.println("Укажите срок годности");
            int longivety = sc.nextInt();
            addProduct(new Bakery(name, price, weight,longivety));
            System.out.println(findProduct(name) + "Добавлен в список!");

        } else System.out.println("Неверно введена команда");
    }
}
