// CoffeeShop/beverages/Espresso.java
package beverages;

public class Espresso extends Coffee {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99; // Base cost of Espresso
    }
}