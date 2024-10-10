// CoffeeShop/beverages/Cappuccino.java
package beverages;

public class Cappuccino extends Coffee {
    public Cappuccino() {
        description = "Cappuccino";
    }

    @Override
    public double cost() {
        return 3.49; // Base cost of Cappuccino
    }
}