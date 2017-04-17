package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Artist implements Serializable{

    private Integer id;
    private String name;
    private Set<Integer> albums;


    public Artist() {
        albums = new HashSet<>();
    }

    public Artist(String name) {
        this();
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getAlbums() {
        return albums;
    }

    public boolean addAlbum(Album album) {
        return albums.add(album.getId());
    }

    public boolean removeAlbum(Album album) {
        return albums.remove(album.getId());
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
