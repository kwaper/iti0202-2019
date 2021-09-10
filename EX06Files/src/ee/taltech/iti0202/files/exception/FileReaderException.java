package ee.taltech.iti0202.files.exception;

import java.io.IOException;

public class FileReaderException extends RuntimeException {

    private String throwMessage;

    private IOException throwReason;

    public FileReaderException(String throwMessage, IOException throwReason) {
        super(throwMessage, throwReason);
    }
}
