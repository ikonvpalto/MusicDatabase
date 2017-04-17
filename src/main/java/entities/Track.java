package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Track implements Serializable {

    private Integer id;
    private String title;
    private Set<Integer> genres;
    private Integer albumId;


    public Track() {
        genres = new HashSet<Integer>();
    }

    public Track(String title) {
        this();
        this.title = title;
    }


    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Integer> getGenres() {
        return genres;
    }

    public boolean add(Genre genre) {
        return genres.add(genre.getId());
    }

    public boolean remove(Genre genre) {
        return genres.remove(genre.getId());
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genres=" + genres +
                ", albumId=" + albumId +
                '}';
    }
}
