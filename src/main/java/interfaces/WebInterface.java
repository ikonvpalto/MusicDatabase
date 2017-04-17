package interfaces;

import com.sun.org.apache.xpath.internal.operations.Bool;
import entities.Album;
import entities.Artist;
import entities.Genre;
import entities.Track;

import java.rmi.Remote;
import java.util.List;

public interface WebInterface extends Remote {

    Integer createArtist(Artist artist) throws Exception;
    List<Artist> readArtists(String pattern) throws Exception;
    Boolean updateArtists(Artist newValues, String pattern) throws Exception;
    Boolean deleteArtists(String pattern) throws Exception;

    Integer createAlbum(Album album) throws Exception;
    List<Album> readAlbums(String pattern) throws Exception;
    Boolean updateAlbums(Album newValues, String pattern) throws Exception;
    Boolean deleteAlbums(String pattern) throws Exception;

    Integer createTrack(Track track) throws Exception;
    List<Track> readTracks(String pattern) throws Exception;
    Boolean updateTracks(Track newValues, String pattern) throws Exception;
    Boolean deleteTracks(String pattern) throws Exception;

    Integer createGenre(Genre genre) throws Exception;
    List<Genre> readGenres(String pattern) throws Exception;
    Boolean updateGenres(Genre newValues, String pattern) throws Exception;
    Boolean deleteGenres(String pattern) throws Exception;


}
