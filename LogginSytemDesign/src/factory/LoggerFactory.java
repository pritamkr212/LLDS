package factory;

import service.LoggerStrategy;
import service.impl.ConsoleStrategyLog;
import service.impl.DBStrategyLog;

public class LoggerFactory {
    public static LoggerStrategy getLoggerStrategy(String type) {
        return switch (type.toLowerCase()) {
            case "console" -> new ConsoleStrategyLog();
            case "db" -> new DBStrategyLog();
            default -> throw new IllegalArgumentException("Invalid logger type: " + type);
        };
    }

}
