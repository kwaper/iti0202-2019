package ee.taltech.iti0202.cakeorder;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Cake {
    @SerializedName("cake_id")
    private String id;
    private String name;
    @SerializedName("BBD")
    private String bbd;
    private double price;
    @SerializedName("kg")
    private double weight;
    private List<String> ingredients;


    public Cake(String name, String bbd, double price, double weight, List<String> ingredients) {
        this.name = name;
        this.bbd = bbd;
        this.price = price;
        this.weight = weight;
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBbd() {
        return bbd;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setId() {
        String[] words = name.split("\\s+");
        String id = "";
        for (String word : words) {
            id += word.substring(0, 1);
        }
        id += words.length;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cake{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", bbd='" + bbd + '\''
                + ", price=" + price
                + ", weight=" + weight
                + ", ingredients=" + ingredients
                + '}';
    }
}
