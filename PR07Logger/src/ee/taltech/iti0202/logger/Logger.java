package ee.taltech.iti0202.logger;

import ee.taltech.iti0202.logger.filter.LogFilter;
import ee.taltech.iti0202.logger.formatter.LogFormatter;

public abstract class Logger {

    public Logger(String tag, LogFilter filter, LogFormatter formatter) {
    }


    protected Logger() {
    }

    protected abstract void writeLog(String message);
}
