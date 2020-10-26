package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTopRepository implements TopRepository {
    private final Database db;
    public DBTopRepository(Database db) {
        this.db = db;
    }
    @Override
    public Iterable <Top> findAll() throws DBException {
            Iterable <Top> topList = new ArrayList<>();
            /*
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

             */
            Top top1 = new Top(1, "Marmelade", 10 );
            Top top2 = new Top(2, "Navn", 10 );
            ((ArrayList<Top>) topList).add(top1);
            ((ArrayList<Top>) topList).add(top2);
        System.out.println(topList);
            return topList;
    }


}





