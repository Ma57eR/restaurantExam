package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.Collection;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {

    @Override
    public HealthyFood foodByName(String name) {
        return null;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return null;
    }

    @Override
    public void add(HealthyFood entity) {

    }
}