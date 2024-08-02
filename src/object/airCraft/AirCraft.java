package src.object.airCraft;

import src.object.airCraft.coordinates.Coordinates;
import src.object.exception.MethodeException;

public class AirCraft extends Flyable {
    protected long id;
    protected String name;
    protected String type;
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

    @Override
    public String toString() {
        return (String.format("%s#%s(%d) ", this.type, this.name, this.id));
    }
}
