package Model;

public class Music {
    private int id;
    private String name;
    private String Album;
    private String Artist;

    public Music(String name) {
        this.name = name;
    }

    public Music() {

    }

    public Music(int id, String name, String album, String artist) {
        this.id = id;
        this.name = name;
        Album = album;
        Artist = artist;
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

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }
}
