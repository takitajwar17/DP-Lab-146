// CoffeeShop/condiments/CondimentDecorator.java
package condiments;

import beverages.Beverage;

public abstract class CondimentDecorator implements Beverage {
    protected Beverage beverage;

    public abstract String getDescription();
}
