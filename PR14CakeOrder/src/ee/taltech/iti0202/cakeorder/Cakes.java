package ee.taltech.iti0202.cakeorder;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cakes {
    @SerializedName("order_id")
    private int orderId;
    @SerializedName("total")
    private double total;
    private List<Cake> cakes;

    public Cakes(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public List<Cake> getCakes() {
        return cakes;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
    }

    @Override
    public String toString() {
        return "Cakes{"
                + "orderId=" + orderId
                + ", cakes=" + cakes
                + '}';

    }
}
