package cupcakeMaster.domain.order;

import java.time.LocalDate;

public class Ordre {
    private int ordre_id;
    private LocalDate date;
    private Customer customer;

    public Ordre(LocalDate date, Customer customer) {

        this.date = date;
        this.customer = customer;
    }

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
