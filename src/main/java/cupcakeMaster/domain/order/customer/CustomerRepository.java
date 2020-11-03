package cupcakeMaster.domain.order.customer;

import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.domain.order.customer.Customer;
import cupcakeMaster.domain.order.customer.CustomerNotFoundException;

import java.sql.SQLException;

public interface CustomerRepository {
    Iterable<Customer> customer();
    Customer findCostumer(String email) throws CustomerNotFoundException, DBException;
    Customer findCostumerFromID(int customer_ID) throws CustomerNotFoundException, DBException;
    Customer commitCustomer(Customer customer) throws DBException, SQLException;
    void updateSaldo(int customer_id,int amount) throws CustomerNotFoundException, DBException;
}
