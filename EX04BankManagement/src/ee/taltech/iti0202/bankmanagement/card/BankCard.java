package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;

public abstract class BankCard {

    private Person owner;
    private Bank bank;
    private BigDecimal balance = BigDecimal.valueOf(0);

    public enum CardType {
        CREDIT, DEBIT
    }

    /**
     * Constructor factory. Return a CreditCard or DebitCard object according to parameter cardType.
     *
     * @param cardType Specifies objected type to be returned.
     * @param bank     Specifies the bank of the created card.
     * @param person   Specifies the card owner.
     * @return
     */
    public static BankCard createCard(CardType cardType, Bank bank, Person person) {
        switch (cardType) {
            case DEBIT:
                DebitCard newDebitCard = new DebitCard();
                newDebitCard.setOwner(person);
                newDebitCard.setBank(bank);
                person.setBankCard(newDebitCard);
                person.setCardType("debit");
                bank.addCustomer(person);
                return newDebitCard;

            case CREDIT:
                CreditCard newCreditCard = new CreditCard();
                newCreditCard.setOwner(person);
                newCreditCard.setBank(bank);
                person.setBankCard(newCreditCard);
                person.setCardType("credit");
                bank.addCustomer(person);
                return newCreditCard;

            default:
                return null;
        }
    }

    /**
     * Deposit given amount to the card.
     *
     * @param value Value to be deposited.
     * @throws TransactionException Thrown if given value is zero or less.
     */
    public void deposit(BigDecimal value) throws TransactionException {
        if (value.compareTo(BigDecimal.ZERO) == 1) {
            this.balance = this.balance.add(value);
            this.setBalance(this.balance);
        } else throw new TransactionException();
    }

    /**
     * Withdraw the given amount from the card. Abstract function - implemented in subclasses CreditCard and DebitCard.
     *
     * @param value Value to be withdrawn.
     * @return Amount withdrawn.
     * @throws TransactionException Thrown if given value cannot be withdrawn for
     *                              various reasons - specified in subclasses.
     */
    public abstract BigDecimal withdraw(BigDecimal value) throws TransactionException;

    public void setMoneyWithdrawDebit(BigDecimal value) {
        this.balance = this.balance.add(value.negate());
    }

    public void setMoneyWithdrawCredit(BigDecimal value) {
        this.balance = this.balance.add(value.negate());
        setBalance(this.balance);
    }

    public void setBalance(BigDecimal val) {
    }


    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }


    public Bank getBank() {
        return this.bank;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public Person getPerson() {
        return this.owner;
    }
}
