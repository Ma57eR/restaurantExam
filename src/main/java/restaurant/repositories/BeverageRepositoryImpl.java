package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.Collection;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {


    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return null;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return null;
    }

    @Override
    public void add(Beverages entity) {

    }
}
