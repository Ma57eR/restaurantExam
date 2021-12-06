package restaurant.entities.tables;

public class Indoors extends BaseTable{
    public static final double pricePerPerson = 3.50;

    public Indoors(int number, int size) {
        super(number, size, pricePerPerson);
    }
}
