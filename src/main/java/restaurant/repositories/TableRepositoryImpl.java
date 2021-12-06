package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table> {
    @Override
    public Collection<Table> getAllEntities() {
        return null;
    }

    @Override
    public void add(Table entity) {

    }

    @Override
    public Table byNumber(int number) {
        return null;
    }
}
