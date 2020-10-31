package cupcakeMaster.domain.order;

import cupcakeMaster.domain.order.customer.Customer;

import java.time.LocalDate;

public abstract class OrdreFactory {

    int ordre_id;
    LocalDate date;
    Customer customer;

    public int getOrdre_id() {
        return ordre_id;
    }

    public void setOrdre_id(int ordre_id) {
        this.ordre_id = ordre_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
