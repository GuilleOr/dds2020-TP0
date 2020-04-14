package ar.com.dds.exceptions;

public class ZeroException extends Exception {

    private static final String errorMessage = "No debería ser cero";

    public ZeroException() {
    }

    public ZeroException(String errorMessage) {
        super(errorMessage);
    }
}
