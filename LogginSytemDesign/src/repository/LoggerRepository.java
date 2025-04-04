package repository;

import entity.Logger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoggerRepository {
    private static LoggerRepository instance;
    private static final Map<String, List<Logger>> repository = new ConcurrentHashMap<>();

    private LoggerRepository() {

    }

    public static LoggerRepository getInstance() {
        if (instance == null) {
            synchronized (LoggerRepository.class) {
                instance = new LoggerRepository();
            }
        }
        return instance;
    }

    public static Map<String, List<Logger>> getRepository() {
        return repository;
    }

}
