package geowear.de.geowear.domain;


public class CacheItem {

    private String name;
    private String description;
    private Position position;

    public Position getPosition() {
        return position;
    }

    public CacheItem(String name, String description, Position position) {
        this.name = name;
        this.description = description;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
