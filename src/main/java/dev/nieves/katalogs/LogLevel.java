package dev.nieves.katalogs;

// Enumeración que representa los niveles de log posibles.
// Cada constante es inmutable y conocida en tiempo de compilación,
// por eso encaja perfectamente con un enum en vez de, por ejemplo, un String.
// Además, cada constante lleva asociado su propio valor numérico codificado,
// usado para el formato corto de las líneas de log.
public enum LogLevel {
    UNKNOWN(0),
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42);

    private final int encodedLevel;

    LogLevel(int encodedLevel) {
        this.encodedLevel = encodedLevel;
    }

    public int getEncodedLevel() {
        return encodedLevel;
    }
}
