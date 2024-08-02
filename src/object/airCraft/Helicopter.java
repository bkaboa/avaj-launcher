package src.object.airCraft;

import java.io.IOException;
import src.object.airCraft.coordinates.Coordinates;
import src.object.exception.UnsupportedWeatherException;
import src.object.logger.Logger;

enum HelicoLog {
    SUN("SUN", "sunny sunglass"),
    RAIN("RAIN", "rainy oooooooh"),
    FOG("FOG", "foggy roting houla"),
    snow("snow", "snowy houla rotor");

    private final String weather;
    private final String message;

    HelicoLog(String p_weather, String p_message) {
        this.weather = p_weather;
        this.message = p_message;
    }

    public String getWeather() {
        return this.weather;
    }

    public static String getMessage(String p_weather) throws UnsupportedWeatherException {
        for (HelicoLog weather : HelicoLog.values()) {
            if (weather.getWeather().equals(p_weather)) {
                return weather.message;
            }
        }
        throw new UnsupportedWeatherException(p_weather);
    }
}

public class Helicopter extends AirCraft{
    Logger logger = Logger.getInstance();

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    private void Moving(String weather) {
        switch (weather) {
            case "SUN" -> {
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
            }
            case "RAIN" -> {
                coordinates.setLatitude(coordinates.getLatitude() + 5);
            }
            case "FOG" -> {
                coordinates.setLatitude(coordinates.getLatitude() + 1);
            }
            case "SNOW" -> {
                coordinates.setHeight(coordinates.getHeight() - 12);
            }
        }
    }

    @Override
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        String message;
        
        message = HelicoLog.getMessage(weather);
        try {
            logger.log(this.toString() + message);
            this.Moving(weather);
            if (coordinates.getHeight() <= 0) {
                weatherTower.unregister(this);
                logger.log(this.toString() + "landing.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

