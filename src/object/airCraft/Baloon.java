package object.airCraft;

import java.io.IOException;
import object.airCraft.coordinates.Coordinates;
import object.exception.UnsupportedWeatherException;
import object.logger.Logger;

enum WeatherLog {
    SUN("SUN", "sunny to the max"),
    RAIN("RAIN", "rainy my baloon is wet"),
    FOG("FOG", "foggy nothing to see"),
    SNOW("SNOW", "snowy my baloon is cold");

    private final String weather;
    private final String message;

    WeatherLog(String p_weather, String p_message) {
        this.weather = p_weather;
        this.message = p_message;
    }

    public String getWeather() {
        return this.weather;
    }

    public static String getMessage(String p_weather) throws UnsupportedWeatherException {
        for (WeatherLog weather : WeatherLog.values()) {
            if (weather.getWeather().equals(p_weather)) {
                return weather.message;
            }
        }
        throw new UnsupportedWeatherException(p_weather);
    }
}

public class Baloon extends AirCraft{
    Logger logger = Logger.getInstance();

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    private void Moving(String weather) {
        switch (weather) {
            case "SUN" -> {
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
            }
            case "RAIN" -> {
                coordinates.setHeight(coordinates.getHeight() + 5);
            }
            case "FOG" -> {
                coordinates.setHeight(coordinates.getHeight() + 3);
            }
            case "SNOW" -> {
                coordinates.setHeight(coordinates.getHeight() - 15);
            }
        }
    }

    @Override
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        String message;
        
        message = WeatherLog.getMessage(weather);
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

