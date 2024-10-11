import products.IProduct;

import java.util.ArrayList;
import java.util.List;

public abstract class Bundle implements IProduct {
    private String name;
    private double discountPercentage;
    protected List<IProduct> products;

    public Bundle(String name, double discountPercentage) {
        this.name = name;
        this.discountPercentage = discountPercentage;
        this.products = new ArrayList<>();
    }

    // Abstract method for building the bundle (implemented by subclasses)
    protected abstract void build();

    public void addProduct(IProduct product) {
        products.add(product);
    }

    @Override
    public String getDetails() {
        StringBuilder result = new StringBuilder("Bundle: " + name + " (Discount: " + discountPercentage + "%)\n");
        for (IProduct product : products) {
            result.append(product.getDetails()).append("\n");
        }
        result.append("Total Price: $").append(calculatePrice());
        return result.toString();
    }

    @Override
    public double calculatePrice() {
        double totalPrice = 0;
        for (IProduct product : products) {
            totalPrice += product.calculatePrice();
        }
        return totalPrice * (1 - discountPercentage / 100);
    }
}
