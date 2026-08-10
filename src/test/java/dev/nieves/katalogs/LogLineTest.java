package dev.nieves.katalogs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LogLineTest {

    @Test
    void parsesInfoLogLevel() {
        LogLine logLine = new LogLine("[INF]: File deleted");
        assertEquals(LogLevel.INFO, logLine.getLogLevel());
    }

    @Test
    void parsesErrorLogLevel() {
        LogLine logLine = new LogLine("[ERR]: Stack Overflow");
        assertEquals(LogLevel.ERROR, logLine.getLogLevel());
    }

    @Test
    void parsesTraceLogLevel() {
        LogLine logLine = new LogLine("[TRC]: Entering method");
        assertEquals(LogLevel.TRACE, logLine.getLogLevel());
    }

    @Test
    void parsesDebugLogLevel() {
        LogLine logLine = new LogLine("[DBG]: Variable value is 42");
        assertEquals(LogLevel.DEBUG, logLine.getLogLevel());
    }

    @Test
    void parsesWarningLogLevel() {
        LogLine logLine = new LogLine("[WRN]: Low disk space");
        assertEquals(LogLevel.WARNING, logLine.getLogLevel());
    }

    @Test
    void parsesFatalLogLevel() {
        LogLine logLine = new LogLine("[FTL]: System crash");
        assertEquals(LogLevel.FATAL, logLine.getLogLevel());
    }
}
