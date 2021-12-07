package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.BaseBeverage;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.BaseTable;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.BeverageRepository;
import restaurant.repositories.interfaces.HealthFoodRepository;
import restaurant.repositories.interfaces.TableRepository;

public class ControllerImpl implements Controller {
//    private List<HealthyFood> healthyFoodList;
//    private List<BaseBeverage> beveragesList;
//    private List<Table> tableList;
    private  final HealthFoodRepository<HealthyFood>  healthFoodRepository;
    private  final BeverageRepository<Beverages> beverageRepository;
    private  final TableRepository<Table> tableRepository;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
//        List<HealthyFood> healthyFoodList = new ArrayList<>();
//        List<BaseBeverage> beveragesList = new ArrayList<>();
//        List<Table> tableList = new ArrayList<>();
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        if (type.equals("Salad")) {
            Food currentFood = new Salad(name, price);
            HealthyFood checkFood = this.healthFoodRepository.foodByName(name);
            if (checkFood == null) {
                healthFoodRepository.add(currentFood);
            } else {
                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
            }
        } else if (type.equals("VeganBiscuits")) {
            Food food = new VeganBiscuits(name, price);
            HealthyFood checkFood = this.healthFoodRepository.foodByName(name);
            if (checkFood == null) {
                this.healthFoodRepository.add(food);
            } else {
                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
            }
        }
        return String.format(OutputMessages.FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        if (type.equals("Fresh")) {
            BaseBeverage currentBeverage = new Fresh(name, counter, brand);
            Beverages checkBeverage = this.beverageRepository.beverageByName(name, brand);
            if (checkBeverage == null) {
            this.beverageRepository.add(currentBeverage);
            } else {
                throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
            }
            }
        if (type.equals("Smoothie")) {
            BaseBeverage currentBeverage = new Smoothie(name, counter, brand);
            Beverages checkBeverage = this.beverageRepository.beverageByName(name, brand);
            if (checkBeverage == null) {
                this.beverageRepository.add(currentBeverage);
            } else {
                throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
            }
        }
        return String.format(OutputMessages.BEVERAGE_ADDED,name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        if (type.equals("Indoors")) {
            BaseTable currentTable = new Indoors(tableNumber, capacity);
            Table checkedTableNumber = this.tableRepository.byNumber(tableNumber);
            if (checkedTableNumber == null) {
                this.tableRepository.add(currentTable);
            } else {
                throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
            }
        }
        if (type.equals("InGarden")) {
            BaseTable currentTable = new InGarden(tableNumber, capacity);
            Table checkedTableNumber = this.tableRepository.byNumber(tableNumber);
            if (checkedTableNumber == null) {
                this.tableRepository.add(currentTable);
            } else {
                throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
            }
        }
        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = this.tableRepository.getAllEntities().stream()
                .filter(t -> t.getSize() >= numberOfPeople)
                .findFirst().orElse(null);

        if (table == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        this.tableRepository.add(table);
        this.tableRepository.byNumber(table.getTableNumber()).reserve(numberOfPeople);
        return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table currentTable = this.tableRepository.byNumber(tableNumber);
        if (currentTable == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);
        if (healthFoodRepository.foodByName(healthyFoodName) == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }
        tableRepository.byNumber(tableNumber).orderHealthy(food);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        //TODO:
        return null;
    }

    @Override
    public String closedBill(int tableNumber) {
        //TODO:
        return null;
    }


    @Override
    public String totalMoney() {
        //TODO:
        return null;
    }
}
