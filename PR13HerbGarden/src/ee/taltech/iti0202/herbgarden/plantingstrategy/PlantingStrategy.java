package ee.taltech.iti0202.herbgarden.plantingstrategy;
import java.util.Map;

public interface PlantingStrategy {

    String[][] plantHerbs(int height, int width, Map<String, Integer> plants);
}
