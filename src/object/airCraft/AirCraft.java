package object.airCraft;

import object.airCraft.coordinates.Coordinates;
import object.exception.MethodeException;

public class AirCraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected AirCraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    @Override
    public void updateConditions() {
        throw new MethodeException("Aircraft", "updateConditions");
    }
}