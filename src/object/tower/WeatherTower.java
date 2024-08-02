package object.tower;
import object.WeatherProvider.WeatherProvider;
import object.airCraft.coordinates.Coordinates;

public class WeatherTower extends Tower {
    public WeatherTower() {}

    public String getWeather(Coordinates coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getInstance();
        return (weatherProvider.getCurrentWeather(coordinates));
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}
