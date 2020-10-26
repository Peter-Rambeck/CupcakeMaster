package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.*;
import cupcakeMaster.domain.shoppingList.ShoppingList;

import java.sql.Connection;
import java.sql.SQLException;

public class DBOrdreLinieRepository implements OrdreLinieRepository {


    private final Database db;

    public DBOrdreLinieRepository(Database db) {
        this.db = db;
    }

    @Override
    public Iterable<OrdreLinie> findAll() {
        return null;
    }

    @Override
    public OrdreLinie find(int id) throws NoOrdreLinieExist {
        try (
                Connection conn = db.connect()) {
        } catch (SQLException throwables) {
            throw  new NoOrdreLinieExist();
        }
        return null;
    }
}
