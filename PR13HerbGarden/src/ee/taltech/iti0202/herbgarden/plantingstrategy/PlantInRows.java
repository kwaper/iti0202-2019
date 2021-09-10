package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PlantInRows implements PlantingStrategy {
    @Override
    public String[][] plantHerbs(int height, int width, Map<String, Integer> plants) {
        String[][] planted = new String[height][width];
        List<String> notSortedKeys = new ArrayList<>(plants.keySet());
        List<Integer> notSortedVal = new ArrayList<>(plants.values());
        List<Integer> vals = new ArrayList<>(plants.values());
        vals.sort(Collections.reverseOrder());
        List<String> plaaaants = new ArrayList<>();
        for (int i : vals) {
            for (int p = 0; p < i; p++) {
                plaaaants.add(notSortedKeys.get(notSortedVal.indexOf(i)));
            }
        }
        int counter = 0;
        for (int k = 0; k < planted.length; k++) {
            for (int b = 0; b < planted[k].length; b++) {
                planted[k][b] = plaaaants.get(counter);
                counter += 1;
            }
        }
        return planted;
    }
}
