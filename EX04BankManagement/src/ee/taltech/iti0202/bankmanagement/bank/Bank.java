package ee.taltech.iti0202.bankmanagement.bank;

import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Bank {

    private String name;
    private Set<Person> customers = new HashSet<>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Set<Person> getCustomers() {
        return this.customers;
    }

    public Boolean addCustomer(Person person) {
        if (!this.customers.contains(person)) {
            this.customers.add(person);
            return true;
        } else return false;
    }

    public Boolean removeCustomer(Person person) {
        if (this.customers.contains(person)) {
            this.customers.remove(person);
            person.setBankCard(null);
            return true;
        } else return false;
    }

    public double getAverageCustomerMonthlyIncome() {
        double income = 0.0;
        if (this.customers.size() > 0) {
            for (Person x : this.customers) {
                income += x.getMonthlyIncome();
            }
            return income / this.customers.size();
        }
        return income;
    }

    public double getAverageCustomerMonthlyIncome(int maxAge) {
        double income = 0.0;
        int customersNum = 0;
        if (this.customers.size() > 0) {
            for (Person x : this.customers) {
                if (x.getAge() <= maxAge) {
                    income += x.getMonthlyIncome();
                    customersNum++;
                }
            }
            if (customersNum != 0) {
                return income / customersNum;
            } else return income;
        }
        return income;
    }

    public double getAverageCustomerMonthlyIncome(int minAge, int maxAge) {
        double income = 0.0;
        int customersNum = 0;
        if (this.customers.size() > 0) {
            for (Person x : this.customers) {
                if (x.getAge() <= maxAge && x.getAge() >= minAge) {
                    income += x.getMonthlyIncome();
                    customersNum++;
                }
            }
            if (customersNum != 0) {
                return income / customersNum;
            } else return income;
        }
        return income;
    }

    public double getAverageCustomerMonthlyIncome(Person.Gender gender) {
        double income = 0.0;
        int customersNum = 0;
        if (this.customers.size() > 0) {
            for (Person x : this.customers) {
                if (x.getGender() == gender) {
                    income += x.getMonthlyIncome();
                    customersNum++;
                }
            }
            if (customersNum != 0) {
                return income / customersNum;
            } else return income;
        }
        return income;
    }

    public Set<Person> getAllCustomersWithCreditCards() {
        Set<Person> customersWithCreditCard = new HashSet<>();
        if (this.customers.size() > 0) {
            for (Person x : this.customers) {
                if (x.getCardType() != null) {
                    if (x.getCardType().equals("credit")) {
                        customersWithCreditCard.add(x);
                    }
                }
            }
            return customersWithCreditCard;
        }
        return customersWithCreditCard;
    }

    public Set<Person> getAllCustomersWithDebitCards() {
        Set<Person> customersWithDebitCard = new HashSet<>();
        if (this.customers.size() > 0) {
            for (Person x : this.customers) {
                if (x.getCardType() != null) {
                    if (x.getCardType().equals("debit")) {
                        customersWithDebitCard.add(x);
                    }
                }
            }
            return customersWithDebitCard;
        }
        return customersWithDebitCard;
    }

    public Optional<Person> getRichestCustomerByGender(Person.Gender gender) {
        Set<Person> personByGender = new HashSet<>();
        BigDecimal topIncome = BigDecimal.ZERO;
        Optional<Person> topPerson = Optional.empty();
        if (this.customers.size() > 0) {
            for (Person x : this.customers) {
                if (x.getGender() == gender) {
                    personByGender.add(x);
                }
            }
            if (personByGender.size() > 0) {
                for (Person i : personByGender) {
                    if (i.getBankCard().isPresent()) {
                        if ((i.getBankCard().get().getBalance()).compareTo(topIncome) == 1) {
                            topIncome = i.getBankCard().get().getBalance();
                            topPerson = Optional.of(i);
                        }
                    }
                }
                return topPerson;
            }
            return topPerson;

        }
        return topPerson;

    }

    @Override
    public String toString() {
        return getName();
    }
}
