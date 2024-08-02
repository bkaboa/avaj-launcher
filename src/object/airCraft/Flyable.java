package src.object.airCraft;

import src.object.tower.WeatherTower;

abstract public class Flyable 
{
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    protected void land() {
        weatherTower.unregister(this);
    }
}
