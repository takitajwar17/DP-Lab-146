// CoffeeShop/beverages/Latte.java
package beverages;

public class Latte extends Coffee {
    public Latte() {
        description = "Latte";
    }

    @Override
    public double cost() {
        return 2.99; // Base cost of Latte
    }
}