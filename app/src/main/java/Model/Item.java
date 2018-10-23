package Model;

/**
 * Created by QHS on 27/09/2018.
 */

public class Item {
    private int id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
