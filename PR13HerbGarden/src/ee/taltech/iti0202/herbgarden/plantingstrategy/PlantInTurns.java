package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PlantInTurns implements PlantingStrategy {
    @Override
    public String[][] plantHerbs(int height, int width, Map<String, Integer> plants) {
        String[][] fiinal = new String[height][width];
        List<String> plantKeys = new ArrayList<>(plants.keySet());
        List<Integer> plantValues = new ArrayList<>(plants.values());
        List<Integer> sortedPlantsVals = new ArrayList<>(plants.values());
        sortedPlantsVals.sort(Comparator.reverseOrder());
        List<String> sortedPlantsKeys = new ArrayList<>();
        List<String> finalList = new ArrayList<>();
        for (Integer i : sortedPlantsVals) {
            sortedPlantsKeys.add(plantKeys.get(plantValues.indexOf(i)));
        }
        List<Integer> newListInt = new ArrayList<>();
        List<Integer> newListIntTWO = new ArrayList<>();

        newListInt.addAll(sortedPlantsVals);
        for (int i = 0; i < sortedPlantsVals.get(0); i++) {
            for (int c = 0; c < sortedPlantsVals.size(); c++) {
                if (newListInt.get(c) > 0) {
                    finalList.add(sortedPlantsKeys.get(c));
                }
            }
            if (i > 0) {
                newListIntTWO.clear();
            }
            newListIntTWO.addAll(newListInt);
            newListInt.clear();
            for (int b : newListIntTWO) {
                newListInt.add(b - 1);
            }
        }
        int counter = 0;
        for (int k = 0; k < fiinal.length; k++) {
            for (int b = 0; b < fiinal[k].length; b++) {
                fiinal[k][b] = finalList.get(counter);
                System.out.println(finalList.get(counter));
                counter += 1;
            }
        }

        return fiinal;

    }
}
