package cupcakeMaster.infrastructure.ShoppingList;

import cupcakeMaster.domain.shoppingList.NoShoppingListExist;
import cupcakeMaster.domain.shoppingList.ShoppingList;
import cupcakeMaster.domain.shoppingList.ShoppingListRepository;
import cupcakeMaster.infrastructure.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class DBShoppinglistRepository implements ShoppingListRepository {

    private final Database db;

    public DBShoppinglistRepository(Database db){
        this.db =db;
    }


    @Override
    public Iterable<ShoppingList> findAll() {
        return null;
    }

    @Override
    public ShoppingList find(int id) throws NoShoppingListExist {
        try (
            Connection conn = db.connect()) {
        } catch (SQLException throwables) {
            throw  new NoShoppingListExist();
        }
        return null;
    }

    @Override
    public ShoppingList create(String name) {
        return null;
    }
}
