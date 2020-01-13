package sample.model;

public class Song {
    private int id;
    private String name;
    private String title;
    private String album;
    
    public Song(int id, String name, String title, String album) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.album = album;
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
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAlbum() {
        return album;
    }
    
    public void setAlbum(String album) {
        this.album = album;
    }
}
