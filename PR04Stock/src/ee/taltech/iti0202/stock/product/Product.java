package ee.taltech.iti0202.stock.product;

import ee.taltech.iti0202.stock.exceptions.StockException;

public class Product {

    private String name;
    private int price;
    private static int id = 0;
    private int productId;

    public Product(String name, int price) throws StockException {
        this.name = name;
        getNextId();
        this.productId = id;
        if (price > 0) {
            this.price = price;
        } else throw new StockException(StockException.Reason.NEGATIVE_PRICE);
    }

    public static int getNextId() {
        id += 1;
        return id;
    }


    public int getId() {
        return this.productId;
    }


    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
