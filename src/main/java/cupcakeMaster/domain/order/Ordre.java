package cupcakeMaster.domain.order;

import cupcakeMaster.domain.order.customer.Customer;

import java.time.LocalDate;

public class Ordre {
    private int ordre_id;
    private LocalDate date;
    private int customer_id;

    public Ordre(LocalDate date, int customer_id) {

        this.date = date;
        this.customer_id = customer_id;
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

    public int getCustomer() {
        return customer_id;
    }

    public void setCustomer(int customer_id) {
        this.customer_id = customer_id;
    }
}
