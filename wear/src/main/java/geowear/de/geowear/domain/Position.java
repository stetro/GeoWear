package geowear.de.geowear.domain;


public class Position {
    private String lat;
    private String lon;

    public Position(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
