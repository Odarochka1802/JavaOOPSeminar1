package org.example;

public class Beer extends Product{

    private int alcogol = 0;
    public Beer(String name, double price) {
        super(name, price);
    }

    public Beer(String name, double price, int alcogol) {
        super(name, price);
        this.alcogol = alcogol;
    }

    @Override
    public String toString() {
        return String.format("%s Содержание алкоголя: '%d' ",super.toString(),alcogol);
    }
}
