package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.*;
import cupcakeMaster.domain.shoppingList.ShoppingList;

import java.sql.*;

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
            throw new NoOrdreLinieExist();
        }
        return null;
    }

    @Override
    public OrdreLinie commitOrdrelinieAndSetID(OrdreLinie ordreLinie, int ordre_ID) {
        try (Connection con = db.connect();) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ordrelinie ( quantity,sum,ordre_id,topping_id,bottom_id) VALUES (?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, ordreLinie.getQuantity());
            ps.setInt(2, ordreLinie.getOrdrelinieSum());
            ps.setInt(3, ordre_ID);
            ps.setInt(4, ordreLinie.getTop().getId());
            ps.setInt(5, ordreLinie.getBottom().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return new OrdreLinie(rs.getInt(1), ordreLinie.getQuantity(), ordreLinie.getOrdrelinieSum(), ordreLinie.getTop(), ordreLinie.getBottom());
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}