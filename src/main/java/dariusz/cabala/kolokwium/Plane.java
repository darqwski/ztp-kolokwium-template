package dariusz.cabala.kolokwium;

public class Plane {
    private String id;
    private double longitude;
    private double latitude;
    private int capacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Plane(String id, double longitude, double latitude, int capacity) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.capacity = capacity;
    }
}
