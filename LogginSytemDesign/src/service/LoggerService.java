package service;

import entity.LogLevel;
import entity.Logger;
import factory.LoggerFactory;

import java.time.LocalDateTime;

public class LoggerService {
    private static LoggerService instance;
    private LoggerStrategy loggerStrategy;

    private LoggerService(LoggerStrategy loggerStrategy) {
        this.loggerStrategy = loggerStrategy;
    }

    public static LoggerService getInstance(String loggerType) {
        if (instance == null) {
            synchronized (LoggerService.class) {
                instance = new LoggerService(LoggerFactory.getLoggerStrategy(loggerType));
            }
        } else if (instance != null && instance.getLoggerType() != loggerType) {
            instance = new LoggerService(LoggerFactory.getLoggerStrategy(loggerType));
        }
        return instance;
    }

    public void log(String loggerId, LogLevel logger, String message, LocalDateTime timestamp) {
        loggerStrategy.log(new Logger(loggerId, logger, message, timestamp));
    }

    public String getLoggerType() {
        return loggerStrategy.getLoggerType();
    }
}
