package cupcakeMaster.api;

import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.domain.order.customer.Customer;
import cupcakeMaster.domain.order.customer.CustomerNotFoundException;
import cupcakeMaster.infrastructure.*;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;
public class CupcakeTest {

    @Test
   /* public void gemcustomer() throws DBException, SQLException, CustomerNotFoundException {
        Database db = new Database();
        Cupcake cupcake= new Cupcake(new DBOrdreLinieRepository(db), new DBBottomRepository(db), new DBTopRepository(db),new DBCustomerRepository(db));
        Customer customer=new Customer("test@gamil.com",0,true,"123455".getBytes(),"fiugi".getBytes());
        cupcake.commitCustomer(customer);
        Customer newcustomer =cupcake.findCustomer("test@gamil.com");
        System.out.println(newcustomer.getCustomerId());

    }*/
  
}