package cupcakeMaster.api;
import cupcakeMaster.domain.order.*;
import cupcakeMaster.domain.order.customer.Customer;
import cupcakeMaster.domain.order.customer.CustomerNotFoundException;
import cupcakeMaster.domain.order.customer.CustomerRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Cupcake {

    private static final String VERSION = "0.1";
    private final OrdreLinieRepository orderlists;
    private final BottomRepository bottoms;
    private final TopRepository tops;
    private final CustomerRepository customers;
    private final OrdreRepository ordrer;
    private int parseInt;

    public Cupcake(OrdreLinieRepository orderlists, BottomRepository buttoms, TopRepository tops,CustomerRepository customers,OrdreRepository ordrer) {
        this.orderlists = orderlists;
        this.bottoms = buttoms;
        this.tops = tops;
        this.customers=customers;
        this.ordrer=ordrer;
    }

    public int commitShoppingCart(List<OrdreLinie>ordreLinier, LocalDate dato, int customer_id) throws DBException {
        return orderlists.commitShoppingCart(ordreLinier,dato,customer_id);
    }
        public String getVersion() {
        return VERSION;
    }

    public Iterable<Top> allTops() {
        try {
            return tops.findAll();
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<Bottom> allBottoms() {
        try {
            return bottoms.findAll();
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
}
public Iterable<Customer> findAll() {
        try {
            return customers.findAll();
        } catch (CustomerNotFoundException | DBException e) {
            throw new RuntimeException();
        }
}

    public Top findTop(int parseInt) throws DBException {
        this.parseInt = parseInt;
        return tops.find(parseInt);
    }

    public Bottom findBottom(int parseInt) throws DBException {
        return bottoms.find(parseInt);
    }
    public Ordre findOrdre(int parseInt) throws DBException, NoOrdreExist {
        return ordrer.find(parseInt);
    }

    public List<OrdreLinie> findOrdreLinierFromOrdreID(int ordre_ID) throws NoOrdreExist {
        return orderlists.findFromOrdreID(ordre_ID);
    }

    public Customer findCustomer (String email) throws DBException, CustomerNotFoundException {
        return customers.findCostumer(email);
    }
    public Customer commitCustomer(Customer customer) throws DBException, SQLException {
        return customers.commitCustomer(customer);
    }
}





