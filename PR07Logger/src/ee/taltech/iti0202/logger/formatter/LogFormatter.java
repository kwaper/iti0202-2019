package ee.taltech.iti0202.logger.formatter;

import ee.taltech.iti0202.logger.log.Log;

public interface LogFormatter {
    String format(Log log);

    public boolean isLoggable(Log log);
}
