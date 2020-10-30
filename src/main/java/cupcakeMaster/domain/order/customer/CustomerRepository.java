package cupcakeMaster.domain.order.customer;

import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.domain.order.customer.Customer;
import cupcakeMaster.domain.order.customer.CustomerNotFoundException;

import java.sql.SQLException;

public interface CustomerRepository {
    Iterable<Customer> customer();
    Customer findCostumer(String email) throws CustomerNotFoundException, DBException;
    Customer commitCustomer(Customer customer) throws DBException, SQLException;
}
