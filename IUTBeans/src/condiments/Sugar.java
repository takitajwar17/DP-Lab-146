// CoffeeShop/condiments/Sugar.java
package condiments;

import beverages.Beverage;

public class Sugar extends CondimentDecorator {
    public Sugar(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return 0.05 + beverage.cost(); // Adds $0.05 for sugar
    }
}