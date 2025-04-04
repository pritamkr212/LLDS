import entity.LogLevel;
import service.LoggerService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LoggerService consoleLoggerService = LoggerService.getInstance("console");
        LoggerService dbLoggerService = LoggerService.getInstance("db");
        LoggerService dbLoggerService1 = LoggerService.getInstance("db");

        consoleLoggerService.log("service-123", LogLevel.DEBUG,"This is Debug Error in Log", LocalDateTime.now());
        dbLoggerService1.log("service-153", LogLevel.INFO,"This is info Error in Log", LocalDateTime.now());
        dbLoggerService.log("service-153", LogLevel.INFO,"This is info Error in Log", LocalDateTime.now());

    }
}