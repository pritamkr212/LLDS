package service;

import entity.Logger;

public interface LoggerStrategy {
    void log(Logger logger);
    String getLoggerType();
}
