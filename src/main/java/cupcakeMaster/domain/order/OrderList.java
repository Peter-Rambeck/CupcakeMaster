package cupcakeMaster.domain.order;

import javax.persistence.criteria.Order;
import java.util.Objects;

public class OrderList {

    private final int id;
    private final String top;
    private final String bottom;
    private final int price;

    public OrderList(int id, String top, String bottom, int price) {
        this.id = id;
        this.top = top;
        this.bottom = bottom;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTop() {
        return top;
    }

    public String getBottom() {
        return bottom;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderList that = (OrderList) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
