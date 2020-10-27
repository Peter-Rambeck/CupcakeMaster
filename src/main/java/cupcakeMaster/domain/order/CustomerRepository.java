package cupcakeMaster.domain.order;

public interface CustomerRepository {
    Iterable<Customer> customer();
    Customer findCostumer(int id) throws CustomerNotFoundException;

}
