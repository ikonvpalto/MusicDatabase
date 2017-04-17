package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Album implements Serializable {

    private Integer artistId;
    private Set<Integer> tracks;
    private Integer id;
    private String title;



    public Album() {
        tracks = new HashSet<>();
    }

    public Album(String title) {
        this();
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Set<Integer> getTracks() {
        return tracks;
    }

    public boolean addTrack(Track track) {
        return tracks.add(track.getId());
    }

    public boolean removeTrack(Track track) {
        return tracks.remove(track.getId());
    }

    @Override
    public String toString() {
        return "Album{" +
                "artistId=" + artistId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
