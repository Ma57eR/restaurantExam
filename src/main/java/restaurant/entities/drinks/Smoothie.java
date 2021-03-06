package restaurant.entities.drinks;

import restaurant.entities.drinks.interfaces.Beverages;

public class Smoothie extends BaseBeverage {
    private static final double smoothiePrice = 4.50;

    public Smoothie(String name, int count, String brand) {
        super(name, count, smoothiePrice, brand);
    }
}
