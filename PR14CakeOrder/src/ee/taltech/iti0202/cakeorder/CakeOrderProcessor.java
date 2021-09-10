package ee.taltech.iti0202.cakeorder;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class CakeOrderProcessor {
    public enum CakeOrderProcessorType {
        MAKE_DAIRY_FREE,
        COUNT_TOTAL_SUM,
        REMOVE_BEST_BEFORE_DAY_OVER

    }

    private int cakeOrder = 0;
    private CakeOrderProcessorType type;
    private Gson gson = new Gson();
    private List<String> milky = Arrays.asList("milk", "cream-cheese", "yoghurt");

    private static final double SUM_INCREASE = 0.1;
    private static final int YEAR = 2019;
    private static final int MONTH = 5;
    private static final int DAY = 6;

    public CakeOrderProcessor(CakeOrderProcessorType type) {
        this.type = type;
    }

    public String process(String jsonInput) {
        cakeOrder++;
        Cakes cakes = gson.fromJson(jsonInput, Cakes.class);
        cakes.setOrderId(cakeOrder);
        if (type == CakeOrderProcessorType.MAKE_DAIRY_FREE) {
            if (cakes.getCakes().size() > 0) {
                for (Cake cake : cakes.getCakes()) {
                    cake.setId();
                    List<String> newIngredients = new ArrayList<>();
                    double increasePrice = 1;
                    for (String ingredient : cake.getIngredients()) {
                        if (milky.contains(ingredient)) {
                            newIngredients.add("plant-" + ingredient);
                            increasePrice += SUM_INCREASE;
                        } else newIngredients.add(ingredient);
                    }
                    cake.setIngredients(newIngredients);
                    DecimalFormat df = new DecimalFormat("#.#");
                    double price = Double.valueOf(df.format(cake.getPrice() * increasePrice));
                    cake.setPrice(price);
                }
            }
        }
        if (type == CakeOrderProcessorType.COUNT_TOTAL_SUM) {
            if (cakes.getCakes().size() > 0) {
                double total = 0;
                for (Cake cake : cakes.getCakes()) {
                    cake.setId();
                    total += cake.getPrice() * cake.getWeight();
                }
                cakes.setTotal(total);
            }
        }
        if (type == CakeOrderProcessorType.REMOVE_BEST_BEFORE_DAY_OVER) {
            if (cakes.getCakes().size() > 0) {
                List<Cake> withoutRemoved = new ArrayList<>();
                for (Cake cake : cakes.getCakes()) {
                    cake.setId();
                    String[] date = cake.getBbd().split("-");
                    if (Integer.valueOf(date[0]) > YEAR) {
                        withoutRemoved.add(cake);
                    }
                    if (Integer.valueOf(date[1]) > MONTH) {
                        withoutRemoved.add(cake);
                    }
                    if (Integer.valueOf(date[1]) == MONTH && Integer.valueOf(date[2]) > DAY) {
                        withoutRemoved.add(cake);
                    }

                }
                cakes.setCakes(withoutRemoved);
            }
        }
        System.out.println(gson.toJson(cakes));
        return gson.toJson(cakes);
    }
}
