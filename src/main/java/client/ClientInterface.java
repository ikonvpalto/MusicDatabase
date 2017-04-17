package client;

import entities.Album;
import entities.Artist;
import entities.Genre;
import entities.Track;
import interfaces.WebInterface;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientInterface implements WebInterface{

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private boolean isConnectionAlive;


    public Integer createArtist(Artist artist) throws Exception {
        return null;
    }

    public List<Artist> readArtists(String pattern) throws Exception {
        return null;
    }

    public Boolean updateArtists(Artist newValues, String pattern) throws Exception {
        return null;
    }

    public Boolean deleteArtists(String pattern) throws Exception {
        return null;
    }

    public Integer createAlbum(Album album) throws Exception {
        return null;
    }

    public List<Album> readAlbums(String pattern) throws Exception {
        return null;
    }

    public Boolean updateAlbums(Album newValues, String pattern) throws Exception {
        return null;
    }

    public Boolean deleteAlbums(String pattern) throws Exception {
        return null;
    }

    public Integer createTrack(Track track) throws Exception {
        return null;
    }

    public List<Track> readTracks(String pattern) throws Exception {
        return null;
    }

    public Boolean updateTracks(Track newValues, String pattern) throws Exception {
        return null;
    }

    public Boolean deleteTracks(String pattern) throws Exception {
        return null;
    }

    public Integer createGenre(Genre genre) throws Exception {
        return null;
    }

    public List<Genre> readGenres(String pattern) throws Exception {
        return null;
    }

    public Boolean updateGenres(Genre newValues, String pattern) throws Exception {
        return null;
    }

    public Boolean deleteGenres(String pattern) throws Exception {
        return null;
    }
}
