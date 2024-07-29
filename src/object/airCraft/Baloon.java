package object.airCraft;

import object.airCraft.coordinates.Coordinates;

public class Baloon extends AirCraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
    }
}