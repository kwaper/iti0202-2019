package ee.taltech.iti0202.shelter.animal;

/**
 * https://en.wikipedia.org/wiki/Hirola
 */
public class Hirola extends Animal {

    private Type type = Type.HIROLA;

    public Hirola(String color) {
        super(color);
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
