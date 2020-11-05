package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.DBException;
import cupcakeMaster.domain.Customer;
import cupcakeMaster.domain.CustomerNotFoundException;
import cupcakeMaster.domain.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

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
    public Iterable<Customer> findAll() throws CustomerNotFoundException, DBException {
        List<Customer> customerList = new ArrayList<>();
        try {
            Connection con = db.connect();
            String SQL = "SELECT * FROM customer";
            PreparedStatement ps = con.prepareStatement(SQL);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String email = rs.getString("email");
                boolean role = false;
                if(rs.getString("role").equals("admin")){role=true;}
                int saldo=rs.getInt("saldo");
                byte[] secret=rs.getBytes("secret");
                byte[] salt=rs.getBytes("salt");
                Customer customer = new Customer(customer_id,email,saldo,role,salt,secret);
                customerList.add(customer);
            }
        } catch ( SQLException ex) {
            throw new DBException(ex.getMessage());
        }
        return customerList;
    }

    @Override
    public Customer findCostumerFromID(int customer_ID) throws CustomerNotFoundException, DBException {
        try {
            Connection con = db.connect();
            String SQL = "SELECT * FROM customer WHERE customer_id=(?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,customer_ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int customer_id=rs.getInt("customer_id");
                String email=rs.getString("email");
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

    //finder customer i DB og lægger amount til hans saldo
    @Override
    public void updateSaldo(int customer_id, int amount) throws CustomerNotFoundException, DBException {
       try {
            Customer customer=findCostumerFromID(customer_id);
            Connection con = db.connect();
            String SQL = "UPDATE customer  SET saldo=(?)WHERE customer_id=(?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,customer.getSaldo()+amount);
            ps.setInt(2,customer_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new CustomerNotFoundException();
        }
    }
}
