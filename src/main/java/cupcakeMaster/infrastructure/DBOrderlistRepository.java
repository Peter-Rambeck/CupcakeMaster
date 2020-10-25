package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.*;
import cupcakeMaster.domain.shoppingList.ShoppingList;

import java.sql.Connection;
import java.sql.SQLException;

public class DBOrderlistRepository implements OrderListRepository {


    private final Database db;

    public DBOrderlistRepository(Database db) {
        this.db = db;
    }

    @Override
    public Iterable<OrderList> findAll() {
        return null;
    }

    @Override
    public ShoppingList find(int id) throws NoOrderListExist {
        try (
                Connection conn = db.connect()) {
        } catch (SQLException throwables) {
            throw  new NoOrderListExist();
        }
        return null;
    }
}
