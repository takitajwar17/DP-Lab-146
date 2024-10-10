// CoffeeShop/beverages/Coffee.java
package beverages;

public abstract class Coffee implements Beverage {
    protected String description = "Unknown Coffee";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 0.0; // Base cost for abstract class
    }
}
