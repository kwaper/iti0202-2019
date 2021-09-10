package ee.taltech.iti0202.bankmanagement.person;

import ee.taltech.iti0202.bankmanagement.card.BankCard;
import ee.taltech.iti0202.bankmanagement.exceptions.PersonException;

import java.util.Optional;

public class Person {

    private String firstName;

    private String lastName;

    private int age;

    private double monthlyIncome;

    private Gender gender;

    private BankCard card;

    private String cardType;

    public enum Gender {
        MALE, FEMALE
    }

    public Person(String firstName, String lastName, int age, Gender gender, double monthlyIncome) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (age > 0) {
            this.age = age;
        } else throw new PersonException();
        if (monthlyIncome >= 0) {
            this.monthlyIncome = monthlyIncome;
        } else throw new PersonException();
        this.gender = gender;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public double getMonthlyIncome() {
        return this.monthlyIncome;
    }

    public void setCardType(String type) {
        this.cardType = type;
    }

    public String getCardType() {
        return this.cardType;
    }

    /**
     * Return Optional.empty() if person has no bankcard.
     *
     * @return Optional of BankCard
     */
    public Optional<BankCard> getBankCard() {
        if (this.card != null) {
            return Optional.of(this.card);
        } else return Optional.empty();
    }

    public void setBankCard(BankCard bankCard) {
        this.card = bankCard;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
