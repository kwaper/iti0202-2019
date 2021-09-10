package ee.taltech.iti0202.birdwatching.bird;

public class Bird {
    enum Age {YOUNGLING, ADULT}

    enum Sex {MALE, FEMALE, UNKNOWN}

    private String species;
    private double weight;
    private double wingspan;
    private Age age;
    private Sex gender;


    Bird(BirdBuilder info) {
        this.species = info.getSpecies();
        this.weight = info.getWeight();
        this.wingspan = info.getWingspan();
        this.age = info.getBirdAge();
        this.gender = info.getBirdSex();
    }

    public String getSpecies() {
        return this.species;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getWingspan() {
        return this.wingspan;
    }

    public Sex getGender() {
        return this.gender;
    }

    public Age getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return species + " " + weight + " " + wingspan + " " + age + " " + gender;
    }
}
