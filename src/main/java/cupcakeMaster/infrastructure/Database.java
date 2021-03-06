package cupcakeMaster.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final String URL = "jdbc:mysql://localhost:3306/cupcake?localTimezone=GMT+2";
    private final String USER = "cupcake";
    private final String PASSWORD="cupcake";


    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

