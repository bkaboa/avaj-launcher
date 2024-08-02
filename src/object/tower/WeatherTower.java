package src.object.tower;
import src.object.WeatherProvider.WeatherProvider;
import src.object.airCraft.coordinates.Coordinates;

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
