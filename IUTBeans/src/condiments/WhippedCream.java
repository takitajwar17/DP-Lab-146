// CoffeeShop/condiments/WhippedCream.java
package condiments;

import beverages.Beverage;

public class WhippedCream extends CondimentDecorator {
    public WhippedCream(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost(); // Adds $0.15 for whipped cream
    }
}