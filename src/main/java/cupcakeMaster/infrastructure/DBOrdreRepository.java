package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBOrdreRepository implements OrdreRepository {
    private final Database db;
    public DBOrdreRepository(Database db) {
        this.db = db;
    }

    @Override
    public List<Ordre> findAll() throws NoOrdreExist {
        ArrayList<Ordre> orders=new ArrayList<>();
        try {
            Ordre ordre;
            Connection con = db.connect();
            String SQL = "SELECT * FROM ordre WHERE status=(?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,"open");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ordre_id = rs.getInt("ordre_id");
                LocalDate date=rs.getDate("date").toLocalDate();
                int customer_id=rs.getInt("customer_id");
                ordre = new Ordre( date,customer_id);
                ordre.setOrdre_id(ordre_id);
                orders.add(ordre);
            }
            return orders;
        } catch (SQLException ex) {
            throw new NoOrdreExist();
        }
    }

    @Override
    public Ordre find(int id) throws NoOrdreExist {
        try {
            Connection con = db.connect();
            String SQL = "SELECT * FROM ordre WHERE ordre_id=(?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int ordre_id = rs.getInt("ordre_id");
                LocalDate date=rs.getDate("date").toLocalDate();
                int customer_id=rs.getInt("customer_id");
                Ordre ordre = new Ordre( date,customer_id);
                ordre.setOrdre_id(ordre_id);
                return ordre;
            }
        } catch (SQLException ex) {
            throw new NoOrdreExist();
        }
        return null;
    }







    @Override
    public int commit(Ordre ordre, int ordre_id) throws DBException {
        return 0;
    }

    @Override
    public void updateOrdreStatus(int ordre_id, String status) throws NoOrdreExist {
        try {
            Connection con = db.connect();
            String SQL = "UPDATE ordre  SET status=(?)WHERE ordre_id=(?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,status);
            ps.setInt(2,ordre_id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new NoOrdreExist();
        }
    }


}
