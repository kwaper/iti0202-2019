package ee.taltech.iti0202.shelter.animal;

/**
 * https://en.wikipedia.org/wiki/Wombat
 */
public class Wombat extends Animal {

    private Type type = Type.WOMBAT;


    public Wombat(String color) {
        super(color);
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
