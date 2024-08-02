package src.object.WeatherProvider;

import src.object.airCraft.coordinates.Coordinates;

public class WeatherProvider {
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    private static class SingletonHolder {
        private static final WeatherProvider INSTANCE = new WeatherProvider();
    }

    public static WeatherProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int weatherIndex = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        return weather[weatherIndex];
    }
}
