package org.example;

public class FastProducts extends Product{

    private int longevity;

    public FastProducts(String name, double  price, int longevity) {
        super(name, price);
        this.longevity = longevity;
    }

    @Override
    public String toString() {
        return String.format("%s Срок годности: '%d'. ",super.toString(),longevity);
    }
}
