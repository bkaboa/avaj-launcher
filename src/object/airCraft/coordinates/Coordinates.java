package src.object.airCraft.coordinates;

public class Coordinates {
    private int longitude = 0;
    private int latitude = 0;
    private int height = 0;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        if (height > 100) {
            this.height = 100;
        }
        else {
            this.height = height;
        }
    }
}
