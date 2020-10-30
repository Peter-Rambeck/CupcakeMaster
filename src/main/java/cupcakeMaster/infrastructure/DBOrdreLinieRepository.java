package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.*;
import cupcakeMaster.domain.shoppingList.ShoppingList;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public OrdreLinie commit(OrdreLinie ordreLinie, int ordre_id) throws DBException {
        try {
            Connection con = db.connect();
            String SQL = "INSERT INTO ordrelinie (QUANTITY, SUM, ORDRE_ID, TOPPING_ID, BOTTOM_ID) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,ordreLinie.getQuantity());
            ps.setInt(  2,(ordreLinie.getBottom().getPrice()+ordreLinie.getTop().getPrice())*ordreLinie.getQuantity());
            ps.setInt(3,ordre_id);
            ps.setInt(4,ordreLinie.getTop().getId());
            ps.setInt(5,ordreLinie.getBottom().getId());


            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ordreLinie.setOrdrelinie_id(rs.getInt("bottom_id"));
                return ordreLinie;
            }

        } catch ( SQLException ex) {
            throw new DBException(ex.getMessage());
        }

        return null;
    }

    @Override
    public int commitShoppingCart(List<OrdreLinie> ordreLinier, LocalDate dato, int customer_id) throws DBException {
        int ordre_id=0;
        try {
            Connection con = db.connect();
            String SQL = "INSERT INTO ordre (date, customer_id) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(dato));
            ps.setInt(  2,customer_id);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ordre_id=rs.getInt("bottom_id");
            }
        } catch ( SQLException ex) {
            throw new DBException(ex.getMessage());
        }
        for (OrdreLinie ordreLinie:ordreLinier) {
            commit(ordreLinie,ordre_id);
        }
    return ordre_id;
    }

}
