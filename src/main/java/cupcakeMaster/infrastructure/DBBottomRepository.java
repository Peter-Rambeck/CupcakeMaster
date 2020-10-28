package cupcakeMaster.infrastructure;
import cupcakeMaster.domain.order.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBBottomRepository implements BottomRepository{
    private final Database db;
    public DBBottomRepository(Database db) {
        this.db = db;
    }

    @Override
    public Iterable<Bottom> findAll() throws DBException {
        List<Bottom> bottomList = null;
        try {
            Connection con = db.connect();
            String SQL = "SELECT * FROM bottom";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                if (bottomList == null) {
                    bottomList = new ArrayList<>();
                }
                int bottom_id = rs.getInt("bottom_id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Bottom bottom = new Bottom(bottom_id, name, price);
                bottomList.add(bottom);
            }
        } catch ( SQLException ex) {
            throw new DBException(ex.getMessage());
        }
        return bottomList;
    }
}
