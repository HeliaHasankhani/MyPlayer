package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QHS on 27/09/2018.
 */

public class Item {
    private int id;
    private String name;
    private List<String> musics;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public Item(int id, String name, List<String> musics) {
        this.id = id;
        this.name = name;
        this.musics = musics;
    }

    public List<String> getMusics() {
        return musics;
    }

    public void setMusics(List<String> musics) {
        this.musics = musics;
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
