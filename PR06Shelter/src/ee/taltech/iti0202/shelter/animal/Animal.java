package ee.taltech.iti0202.shelter.animal;

public abstract class Animal {
    public enum Type {
        HIROLA, TARANTULA, WOMBAT
    }

    private String color;

    public Animal(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Type getType() {
        return null;
    }
}
