package restaurant.entities.drinks;

public class Fresh extends BaseBeverage {
    public static final double freshPrice = 3.50;

    public Fresh(String name, int count,  String brand) {
        super(name, count, freshPrice, brand);
    }
}
