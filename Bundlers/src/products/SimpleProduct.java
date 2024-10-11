package products;

import products.IProduct;

public class SimpleProduct implements IProduct {
    private String name;
    private String description;
    private double price;

    public SimpleProduct(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDetails() {
        return name + ": $" + price + " - " + description;
    }

    @Override
    public double calculatePrice() {
        return price;
    }
}
