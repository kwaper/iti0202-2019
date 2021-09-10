package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;

import java.math.BigDecimal;

public final class CreditCard extends BankCard {

    private BigDecimal balance;

    private static final int MAX_DEBT = 5001;
    private static final int START_BALANCE = 10000;


    CreditCard() {
        this.balance = BigDecimal.valueOf(START_BALANCE);
    }


    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        if (this.getDebt().compareTo(BigDecimal.valueOf(MAX_DEBT).negate()) == 1) {
            if ((((this.balance.add(value.negate())).add(this.getDebt()))
                    .compareTo(BigDecimal.valueOf(MAX_DEBT).negate())) == 1) {
                this.balance = this.balance.add(value.negate());
                return value;
            } else throw new TransactionException();
        } else throw new TransactionException();
    }

    @Override
    public BigDecimal getBalance() {
        if (this.balance.compareTo(BigDecimal.valueOf(0)) == -1) {
            return BigDecimal.valueOf(0);
        } else return this.balance;
    }

    public BigDecimal getDebt() {
        if (this.balance.compareTo(BigDecimal.valueOf(0)) == -1) {
            return this.balance.abs();
        } else return BigDecimal.valueOf(0);
    }

    @Override
    public void setBalance(BigDecimal val) {
        this.balance = this.getBalance().add(val.add(getDebt().multiply(BigDecimal.valueOf(2)).negate()));
    }
}
