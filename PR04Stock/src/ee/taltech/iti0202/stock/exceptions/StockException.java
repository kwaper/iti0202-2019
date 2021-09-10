package ee.taltech.iti0202.stock.exceptions;

/**
 * Special exception for Stock program.
 * <p>
 * You MUST NOT change anything here!
 * Use this exception in your implementation.
 */
public class StockException extends Exception {

    /**
     * Different reasons for exception.
     * <p>
     * Another option would be to have separate classes for each reason.
     * E.g. NegativePriceException etc.
     */
    public enum Reason {
        NEGATIVE_PRICE,
        STOCK_IS_FULL,
        PACKAGE_IS_FULL,
        STOCK_ALREADY_CONTAINS_PRODUCT
    }

    private Reason reason;

    public StockException(Reason reason) {
        this.reason = reason;
    }

    public Reason getReason() {
        return reason;
    }

    @Override
    public String getMessage() {
        return toString();
    }

    @Override
    public String toString() {
        return getReason().toString();
    }
}
