package service.impl;

import entity.Logger;
import repository.LoggerRepository;
import service.LoggerStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBStrategyLog implements LoggerStrategy {
    private Map<String, List<Logger>> logDB = LoggerRepository.getInstance().getRepository();
    @Override
    public void log(Logger logger) {
        logDB.computeIfAbsent(logger.getLoggerId(), k -> new ArrayList<>()).add(logger);
        System.out.println(logger.toString());
    }

    @Override
    public String getLoggerType() {
        return "db";
    }

}
