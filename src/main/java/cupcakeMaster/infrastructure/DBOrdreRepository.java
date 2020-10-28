package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.Ordre;
import cupcakeMaster.domain.order.OrdreLinie;
import cupcakeMaster.domain.order.OrdreRepository;

import java.sql.*;

public class DBOrdreRepository implements OrdreRepository {
    private final Database db;
    public DBOrdreRepository(Database db) {
        this.db = db;
    }
    @Override
    public Ordre commitOrdreAndSetID(Ordre ordre) {

        try ( Connection con = db.connect();) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ordre ( date, customer_id) VALUES (?,?);",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setDate(1, java.sql.Date.valueOf(ordre.getDate()));
            ps.setInt(2, 1);//      Skal ændres til customer ID----------------
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            Ordre ordreWithID;
            if (rs.next()) {
                 ordreWithID =new Ordre(rs.getInt(1),ordre.getDate(),ordre.getCustomer());
            } else {
                return null;
            }
            DBOrdreLinieRepository dbOrdreLinieRepository= new DBOrdreLinieRepository(db);
            for (OrdreLinie ordreLinie :ordre.getOrdreLinier()) {
               OrdreLinie ordreLinieWithID= dbOrdreLinieRepository.commitOrdrelinieAndSetID(ordreLinie,rs.getInt(1));
               ordreWithID.addOrdrelinie(ordreLinieWithID);
            }
            return ordreWithID;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
