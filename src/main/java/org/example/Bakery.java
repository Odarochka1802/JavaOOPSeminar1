package org.example;

public class Bakery extends Product{
    private double weight;
    private int longivety;
    public Bakery(String name, double price, double weight, int longivety) {
        super(name, price);
        this.weight = weight;
        this.longivety = longivety;

    }

    @Override
    public String toString() {
        return String.format("%s Вес изделия: %.2f, Срок хранения: %d ",super.toString(),weight,longivety);
    }
}
