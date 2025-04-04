package service.impl;

import entity.Logger;
import service.LoggerStrategy;

public class ConsoleStrategyLog implements LoggerStrategy {
    @Override
    public void log(Logger logger) {
        System.out.println(logger.toString());
    }

    @Override
    public String getLoggerType() {
        return "console";
    }
}
