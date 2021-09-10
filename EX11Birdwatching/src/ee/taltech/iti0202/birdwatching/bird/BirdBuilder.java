package ee.taltech.iti0202.birdwatching.bird;

public class BirdBuilder {
    private String species;
    private double weight;
    private double wingspan;
    private Bird.Age birdAge;
    private Bird.Sex birdSex;

    public BirdBuilder setParams(String species, double weight, double wingspan) {
        this.species = species;
        this.weight = weight;
        this.wingspan = wingspan;
        return this;
    }

    public BirdBuilder setAge(Bird.Age age) {
        this.birdAge = age;
        return this;
    }

    public BirdBuilder setGender(Bird.Sex gender) {
        this.birdSex = gender;
        return this;
    }

    public String getSpecies() {
        return species;
    }

    public double getWeight() {
        return weight;
    }

    public double getWingspan() {
        return wingspan;
    }

    public Bird.Age getBirdAge() {
        return birdAge;
    }

    public Bird.Sex getBirdSex() {
        return birdSex;
    }

    public Bird createBird() {
        return new Bird(this);
    }
}
