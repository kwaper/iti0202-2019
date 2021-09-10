package ee.taltech.iti0202.birdwatching.bird;

import java.io.IOException;

public class BirdDataException extends IOException {
    private IOException throwReason;

    public BirdDataException(IOException throwReason){
        super(throwReason);
    }
}
