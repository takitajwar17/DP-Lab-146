// CoffeeShop/Main.java

import beverages.Beverage;
import beverages.Espresso;
import beverages.Latte;
import condiments.Milk;
import condiments.Sugar;
import condiments.WhippedCream;

public class Main {
    public static void main(String[] args) {
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new Latte();
        beverage2 = new Milk(beverage2); // Adding Milk
        beverage2 = new Sugar(beverage2); // Adding Sugar
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new Espresso();
        beverage3 = new WhippedCream(beverage3); // Adding Whipped Cream
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
