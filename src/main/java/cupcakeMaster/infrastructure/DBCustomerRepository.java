package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.Bottom;
import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.domain.order.customer.Customer;
import cupcakeMaster.domain.order.customer.CustomerNotFoundException;
import cupcakeMaster.domain.order.customer.CustomerRepository;

import java.sql.*;

public class DBCustomerRepository implements CustomerRepository {
    private final Database db;
    public DBCustomerRepository(Database db) {
        this.db = db;
    }

    @Override
    public Iterable<Customer> customer() {
        return null;
    }

    @Override
    public Customer findCostumer(String email) throws CustomerNotFoundException, DBException {
        try {
            Connection con = db.connect();
            String SQL = "SELECT * FROM customer WHERE email=(?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int customer_id=rs.getInt("customer_id");
                boolean role=false;
                if(rs.getString("role").equals("admin")){role=true;}
                int saldo=rs.getInt("saldo");
                byte[] secret=rs.getBytes("secret");
                byte[] salt=rs.getBytes("salt");
                Customer customer=new Customer(customer_id,email,saldo,role,salt,secret);


                return customer;
            }
        } catch ( SQLException ex) {
            throw new DBException(ex.getMessage());
        }
        return null;
    }

    @Override
    public Customer commitCustomer(Customer customer) throws DBException{
        try {
            Connection con = db.connect();
            String SQL = "INSERT INTO customer (email,role,saldo,salt,secret) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getEmail());
            if (customer.isAdmin()) {
                ps.setString(2, "admin");
            } else {
                ps.setString(2, "customer");}
            ps.setInt(3,customer.getSaldo());
            ps.setBytes(4,customer.getSalt());
            ps.setBytes(5,customer.getSecret());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                customer.setCustomerId(rs.getInt(1));
                return customer;
            }
        }
         catch ( SQLException ex) {
            throw new DBException(ex.getMessage());
        }

        return null;

    }
}
