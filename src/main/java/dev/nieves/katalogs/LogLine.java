package dev.nieves.katalogs;

// Representa una línea de log con el formato "[<LVL>]: <MESSAGE>".
public class LogLine {

    private final String rawLogLine;

    public LogLine(String rawLogLine) {
        this.rawLogLine = rawLogLine;
    }

    // Extrae y traduce el nivel de log abreviado (ej. "INF") a su
    // correspondiente valor del enum LogLevel (ej. LogLevel.INFO).
    public LogLevel getLogLevel() {
        String shortLevel = extractShortLevel();

        switch (shortLevel) {
            case "TRC":
                return LogLevel.TRACE;
            case "DBG":
                return LogLevel.DEBUG;
            case "INF":
                return LogLevel.INFO;
            case "WRN":
                return LogLevel.WARNING;
            case "ERR":
                return LogLevel.ERROR;
            case "FTL":
                return LogLevel.FATAL;
            default:
                return LogLevel.UNKNOWN;
        }
    }

    // Genera el formato corto "[<ENCODED_LEVEL>]:<MESSAGE>" para
    // reducir el espacio de almacenamiento de las líneas de log.
    public String getOutputForShortLog() {
        int encodedLevel = getLogLevel().getEncodedLevel();
        String message = extractMessage();
        return encodedLevel + ":" + message;
    }

    // Método auxiliar privado: aísla la lógica de extracción del
    // corchete inicial para no repetirla en otros métodos.
    private String extractShortLevel() {
        int start = rawLogLine.indexOf('[') + 1;
        int end = rawLogLine.indexOf(']');
        return rawLogLine.substring(start, end);
    }

    // Extrae el mensaje, es decir, todo lo que va después de "]: ".
    private String extractMessage() {
        int messageStart = rawLogLine.indexOf(']') + 3;
        return rawLogLine.substring(messageStart);
    }

}


