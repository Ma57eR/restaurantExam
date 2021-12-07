package restaurant.repositories;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.*;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {

    private List<HealthyFood> foods;

    public HealthFoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
       return this.foods.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);

    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return this.foods;
    }

    @Override
    public void add(HealthyFood entity) {
        foods.add(entity);
    }
}