package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.DBException;
import cupcakeMaster.domain.Top;
import cupcakeMaster.domain.TopRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBTopRepository implements TopRepository {
    private final Database db;
    public DBTopRepository(Database db) {
        this.db = db;
    }
    @Override
    public Iterable <Top> findAll() throws DBException {
            ArrayList <Top> topList = new ArrayList<>();

            try {
                Connection con = db.connect();
                String SQL = "SELECT * FROM topping";
                PreparedStatement ps = con.prepareStatement(SQL);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    if (topList == null){
                        topList = new ArrayList<>();
                    }
                    int topping_id = rs.getInt("topping_id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    Top top = new Top(topping_id, name,price);
                    topList.add(top);
                }
            } catch (SQLException ex) {
                throw new DBException(ex.getMessage());
            }
            return topList;
    }

    @Override
    public Top find(int parseInt) throws DBException {


        try {
            Connection con = db.connect();
            String SQL = "SELECT * FROM topping WHERE topping_id=(?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,parseInt);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int topping_id = rs.getInt("topping_id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Top top = new Top(topping_id, name,price);
                return top;
            }
        } catch (SQLException ex) {
            throw new DBException(ex.getMessage());
        }
        return null;
    }


}





