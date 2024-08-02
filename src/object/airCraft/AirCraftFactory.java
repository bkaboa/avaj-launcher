package object.airCraft;

import object.airCraft.coordinates.Coordinates;
import object.exception.AirCraftNotSupportedException;

public class AirCraftFactory {
    private AirCraftFactory()  {}
    private static long airCraftId = 0;

    private static class SingletonHolder {
        private static final AirCraftFactory INSTANCE = new AirCraftFactory();
    }

    public static AirCraftFactory getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public static Flyable newAircraft(String type, String name, Coordinates coordinates)
    throws AirCraftNotSupportedException {
        switch (type) {
            case "Baloon" -> {
                return new Baloon(AirCraftFactory.nextId(), name, coordinates);
            } case "JetPlane" -> {
                return new JetPlane(AirCraftFactory.nextId(), name, coordinates);
            } case "Helicopter" -> {
                return new Helicopter(AirCraftFactory.nextId(), name, coordinates);
            }
        }
        throw new AirCraftNotSupportedException("The aircraft type " + type + " is not supported");
    }

    public static long nextId() {
        return airCraftId++;
    }
}
