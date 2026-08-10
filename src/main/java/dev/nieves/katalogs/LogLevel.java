package dev.nieves.katalogs;

// Enumeración que representa los niveles de log posibles.
// Cada constante es inmutable y conocida en tiempo de compilación,
// por eso encaja perfectamente con un enum en vez de, por ejemplo, un String.
public enum LogLevel {
    TRACE,
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL
}
