package server;

import entities.Album;
import entities.Artist;
import entities.Genre;
import entities.Track;
import interfaces.WebInterface;

import java.util.List;

public class ServerInterface implements WebInterface {
    public Integer createArtist(Artist artist) throws Exception {
        return DBInterface.getInstance().saveArtist(artist);
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
        return DBInterface.getInstance().saveAlbum(album);
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
        return DBInterface.getInstance().saveTrack(track);
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
        return DBInterface.getInstance().saveGenre(genre);
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
