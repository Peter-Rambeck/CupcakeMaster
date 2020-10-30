package cupcakeMaster.domain.order.customer;

import cupcakeMaster.domain.order.customer.Customer;
import cupcakeMaster.domain.order.customer.CustomerNotFoundException;

public interface CustomerRepository {
    Iterable<Customer> customer();
    Customer findCostumer(int id) throws CustomerNotFoundException;

}
