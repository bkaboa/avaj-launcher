package object.airCraft;

import object.airCraft.coordinates.Coordinates;

public class AirCraftFactory {
    private AirCraftFactory()  {}

    private static class SingletonHolder {
        private static final AirCraftFactory INSTANCE = new AirCraftFactory();
    }

    public static AirCraftFactory getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "Baloon":
                return new Baloon(0, name, coordinates);
            case "JetPlane":
                return new JetPlane(0, name, coordinates);
            case "Helicopter":
                return new Helicopter(0, name, coordinates);
            default:
                return null;
        }
    }
}
