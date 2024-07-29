package object.airCraft;

import object.airCraft.coordinates.Coordinates;

public class JetPlane extends AirCraft{

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions()
    {}
}
