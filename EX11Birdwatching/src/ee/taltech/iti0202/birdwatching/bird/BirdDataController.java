package ee.taltech.iti0202.birdwatching.bird;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BirdDataController {
    private List<Bird> birds = new ArrayList<>();
    private List<String> dataInfoLines = new ArrayList<>();

    public void readBirdDataFromCsvFile(String filename) throws BirdDataException{
        String fileName = filename;

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(dataInfoLines::add);

        } catch (IOException e) {
            e.printStackTrace();
            throw new BirdDataException(e);
        }
    }

    public List<String> getDataInfoLines(){
        return dataInfoLines;
    }

    public void createBirdsByInfo(){
        for (String data : dataInfoLines){
            String[] birdInfo = data.split(",");
            BirdBuilder birdBuilder = new BirdBuilder();
            birdBuilder.setParams(birdInfo[0], Double.valueOf(birdInfo[1]), Double.valueOf(birdInfo[2]));
            if (!birdInfo[3].equals("unknown")){
                birdBuilder.setGender(Bird.Sex.valueOf(birdInfo[3].toUpperCase()));
            }
            if (!birdInfo[4].equals("unknown")){
                birdBuilder.setAge(Bird.Age.valueOf(birdInfo[4].toUpperCase()));
            }
            birds.add(birdBuilder.createBird());
        }
        System.out.println(birds);
    }


    public List<Bird> getBirds() {
        return birds;
    }
}
