package src.object.exception;

public class MethodeException extends RuntimeException {
    public MethodeException(String typeClass, String methode) {
        super("the class" + typeClass + "must implement the method " + methode);
    }
}
