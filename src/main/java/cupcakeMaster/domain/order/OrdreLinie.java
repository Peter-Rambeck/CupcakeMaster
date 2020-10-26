package cupcakeMaster.domain.order;

import java.util.Objects;

public class OrdreLinie {

    private  int ordrelinie_id;
    private  int quantity;
    private  int ordrelinieSum;
    private  Top top;
    private  Bottom bottom;


    public OrdreLinie(int ordrelinie_id, int quantity, int sum, Top top, Bottom bottom) {
        this.ordrelinie_id = ordrelinie_id;
        this.quantity = quantity;
        this.ordrelinieSum = (top.getPrice()+bottom.getPrice())*quantity;
        this.top = top;
        this.bottom = bottom;
    }

    public void setOrdrelinie_id(int ordrelinie_id) {
        this.ordrelinie_id = ordrelinie_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrdrelinieSum(int ordrelinieSum) {
        this.ordrelinieSum = ordrelinieSum;
    }

    public void setTop(Top top) {
        this.top = top;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public int getOrdrelinie_id() {
        return ordrelinie_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrdrelinieSum() {
        return ordrelinieSum;
    }

    public Top getTop() {
        return top;
    }

    public Bottom getBottom() {
        return bottom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdreLinie that = (OrdreLinie) o;
        return ordrelinie_id == that.ordrelinie_id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordrelinie_id, quantity, ordrelinieSum, top, bottom);
    }

    @Override
    public String toString() {
        return "OrdreLinie{" +
                "ordrelinie_id=" + ordrelinie_id +
                ", quantity=" + quantity +
                ", ordrelinieSum=" + ordrelinieSum +
                ", top=" + top +
                ", bottom=" + bottom +
                '}';
    }
}
