package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PlantInColumns implements PlantingStrategy {
    @Override
    public String[][] plantHerbs(int height, int width, Map<String, Integer> plants) {
        String[][] planted = new String[height][width];
        List<String> notSortedKeys = new ArrayList<>(plants.keySet());
        List<Integer> notSortedVal = new ArrayList<>(plants.values());
        List<Integer> vals = new ArrayList<>(plants.values());
        Collections.sort(vals);
        List<String> plaaaants = new ArrayList<>();
        for (int i : vals) {
            for (int p = 0; p < i; p++) {
                plaaaants.add(notSortedKeys.get(notSortedVal.indexOf(i)));
            }
        }
        int counter = 0;
        for (int i = 0; i < width; i++) {
            for (int h = 0; h < height; h++) {
                planted[h][i] = plaaaants.get(counter);
                counter += 1;
            }
        }

        return planted;
    }

}
