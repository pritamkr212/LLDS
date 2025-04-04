package entity;

import java.time.LocalDateTime;

public class Logger {
    private String loggerId;
    private LogLevel logLevel;
    private String message;
    private LocalDateTime timestamp;

    public Logger(String loggerId, LogLevel logLevel, String message, LocalDateTime timestamp) {
        this.loggerId = loggerId;
        this.logLevel = logLevel;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getLoggerId() {
        return loggerId;
    }

    public void setLoggerId(String loggerId) {
        this.loggerId = loggerId;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Logger{" +
                "loggerId='" + loggerId + '\'' +
                ", logLevel=" + logLevel +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
