package ar.com.dds.exceptions;

public class NoArticuloException extends Throwable {
    private static final String errorMessage = "los items no son de tipo articulo";

    public NoArticuloException() {
    }

    public NoArticuloException(String errorMessage) {
        super(errorMessage);
    }
}