package src.object.exception;

public class UnsupportedWeatherException extends RuntimeException {
    public UnsupportedWeatherException(String weather) {
        super("The weather " + weather + " is not supported");
    }
}
