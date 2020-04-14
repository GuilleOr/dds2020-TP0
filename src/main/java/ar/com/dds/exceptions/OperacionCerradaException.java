package ar.com.dds.exceptions;

public class OperacionCerradaException extends Throwable {
    private static final String errorMessage = "La operacion ya está cerrada.";

    public OperacionCerradaException() {
    }

    public OperacionCerradaException(String errorMessage) {
        super(errorMessage);
    }
}
