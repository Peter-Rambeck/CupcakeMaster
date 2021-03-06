package cupcakeMaster.api;
import cupcakeMaster.domain.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Cupcake {

    private static final String VERSION = "0.1";
    private final OrdreLinieRepository orderlists;
    private final BottomRepository bottoms;
    private final TopRepository tops;
    private final CustomerRepository customers;
    private final OrdreRepository ordrer;
    private int parseInt;


    //bruges til at inatantierer  de repositories api bruger
    public Cupcake(OrdreLinieRepository orderlists, BottomRepository buttoms, TopRepository tops,CustomerRepository customers,OrdreRepository ordrer) {
        this.orderlists = orderlists;
        this.bottoms = buttoms;
        this.tops = tops;
        this.customers=customers;
        this.ordrer=ordrer;
    }

     //løber alle ordelinier i ordren igennem og lægger deres priser sammen,
    // returnerer den samlede pris
    public int getPrice(int Orderid) {
        int price = 0;
        try {
            List<OrdreLinie> ordreLinier = findOrdreLinierFromOrdreID(Orderid);
            for (OrdreLinie ordreLinie : ordreLinier) {
                price = price + ordreLinie.getOrdrelinieSum();
            }
        }
            catch (NoOrdreExist noOrdreExist) {
                noOrdreExist.printStackTrace();
            }
        return price;
    }

    // kalder bare commitshoppingcart i OrdreLinieRepositiry
    public int commitShoppingCart(List<OrdreLinie> ordreLinier, LocalDate dato, int customer_id) throws DBException {
        return orderlists.commitShoppingCart(ordreLinier,dato,customer_id);
    }


    public String getVersion() {
        return VERSION;
    }

    //kalder bare allTops i Toprepository
    public Iterable<Top> allTops() {
        try {
            return tops.findAll();
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }

    //laver et hashmap over åbne ordre og lister med deres ordrelinier
    public HashMap<Integer,List<OrdreLinie>> findOpenOrdersAndOrdreLines() throws NoOrdreExist {
        HashMap<Integer,List<OrdreLinie>> ordreMap=new HashMap<>();
        Iterable<Ordre> orders=findOpenOrders();
        for (Ordre ordre:orders) {
            List<OrdreLinie> ordreLinier=findOrdreLinierFromOrdreID(ordre.getOrdre_id());
            ordreMap.put(ordre.getOrdre_id(),ordreLinier);
        }
        return ordreMap;
    }

    public Iterable<Bottom> allBottoms() {
        try {
            return bottoms.findAll();
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }

    // finder alle customers
    public Iterable<Customer> findAll() {
            try {
                return customers.findAll();
            } catch (CustomerNotFoundException | DBException e) {
                throw new RuntimeException();
            }
    }


    // sætter ordre status til deleted vha ordreRepository
    public void deleteOrder(int order_id){
        try {
            ordrer.updateOrdreStatus(order_id,"deleted");
        } catch (NoOrdreExist noOrdreExist) {
            noOrdreExist.printStackTrace();
        }
    }
    // sætter ordre status til closed vha ordreRepository
    public void closeOrder(int order_id){
        try {
            ordrer.updateOrdreStatus(order_id,"closed");
        } catch (NoOrdreExist noOrdreExist) {
            noOrdreExist.printStackTrace();
        }
    }

    //finder alle ordrer hvsi status er open vha ordrerepository
    public List<Ordre> findOpenOrders() {
        try {
            return ordrer.findAll();
        } catch (NoOrdreExist noOrdreExist) {
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

    public Customer findCustomer (String email)  {
        try {
            return customers.findCostumer(email);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Customer commitCustomer(Customer customer) throws DBException, SQLException {
        return customers.commitCustomer(customer);
    }

    public Customer findCustomerFromID(int customer_id) {
        try {
            return customers.findCostumerFromID(customer_id);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSaldo(int orderToUpdate, int price) {
        try {
            customers.updateSaldo(orderToUpdate,price);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}





