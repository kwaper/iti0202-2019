package ee.taltech.iti0202.shelter.animal;

/**
 * https://en.wikipedia.org/wiki/Tarantula
 */
public class Tarantula extends Animal {

    private Type type = Type.TARANTULA;


    public Tarantula(String color) {
        super(color);
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
