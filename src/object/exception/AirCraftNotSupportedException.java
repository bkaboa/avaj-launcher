package src.object.exception;

public class AirCraftNotSupportedException extends RuntimeException {
    public AirCraftNotSupportedException(String type) {
        super("The aircraft type " + type + " is not supported");
    }
}
