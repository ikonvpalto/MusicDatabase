package server;

import entities.*;
import entities.Track;

import javax.sound.midi.*;
import java.sql.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DBInterface {

    private static final String DB_ADDRESS = "jdbc:mysql://localhost:3306/music?autoReconnect=true&useSSL=false";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";


    private Connection connection;
    private Statement statement;

    private DBInterface() throws SQLException {
        connection = DriverManager.getConnection(DB_ADDRESS, DB_USERNAME, DB_PASSWORD);
        statement = connection.createStatement();
    }


    private static DBInterface instance;
    public static DBInterface getInstance() throws SQLException{
        if (null == instance)
            instance = new DBInterface();
        return instance;
    }


    public int getLastInsertID(String table) throws SQLException {
        statement.executeQuery(String.format("SELECT id FROM %s WHERE id = LAST_INSERT_ID();", table));
        ResultSet result = statement.getResultSet();
        result.next();
        int id = result.getInt(1);
        try {
            result.close();
        } catch (SQLException e) {}
        return id;
    }


    public int saveArtist(Artist artist) throws SQLException {
        String saveCommand = String.format(
                "INSERT INTO artists (name) VALUES ('%s');",
                artist.getName());
        statement.execute(saveCommand);
        int id = getLastInsertID("artists");
        return id;
    }

    public Artist getArtist(Integer id) throws SQLException {
        StringBuilder command = new StringBuilder();
        command.append("SELECT * FROM artists WHERE id = ").append(id).append(";");

        statement.executeQuery(command.toString());

        ResultSet result = statement.getResultSet();
        result.next();
        Artist artist = new Artist();
        artist.setId(result.getInt("id"));
        artist.setName(result.getString("name"));

        return artist;
    }
    public Set<Artist> getArtists(String pattern) throws SQLException{
        if (null == pattern || 0 == pattern.length())
            pattern = "";
        else
            pattern = "WHERE " + pattern;

        StringBuilder command = new StringBuilder("SELECT * FROM artists ").append(pattern).append(";");

        statement.executeQuery(command.toString());

        Set<Artist> artists = new HashSet<>();
        ResultSet result = statement.getResultSet();
        while (result.next()) {
            Artist artist = new Artist();
            artist.setId(result.getInt("id"));
            artist.setName(result.getString("name"));
            artists.add(artist);
        }

        return artists;
    }


    public int saveAlbum(Album album) throws SQLException {
        String command = String.format(
                "INSERT INTO albums (title, artist_id) VALUES ('%s', %d);",
                album.getTitle(),
                album.getArtistId());
        statement.execute(command);
        int id = getLastInsertID("albums");

        command = String.format(
                "INSERT INTO artists_albums (artist_id, album_id) VALUES (%d, %d);",
                album.getArtistId(),
                id);
        statement.execute(command);

        return id;
    }

    public Album getAlbum(Integer id) throws SQLException {
        StringBuilder command = new StringBuilder();

        command.append("SELECT * FROM albums WHERE id = ").append(id).append(";");

        statement.executeQuery(command.toString());

        ResultSet result = statement.getResultSet();
        result.next();
        Album album = new Album();
        album.setId(result.getInt("id"));
        album.setTitle(result.getString("title"));
        album.setArtistId(result.getInt("artist_id"));

        return album;
    }
    public Set<Album> getAlbums(String pattern) throws SQLException {
        if (null == pattern || 0 == pattern.length())
            pattern = "";
        else
            pattern = "WHERE " + pattern;

        StringBuilder command = new StringBuilder("SELECT * FROM albums ").append(pattern).append(";");
        statement.executeQuery(command.toString());

        ResultSet result = statement.getResultSet();
        Set<Album> albums = new HashSet<>();
        while (result.next()) {
            Album album = new Album();
            album.setId(result.getInt("id"));
            album.setTitle(result.getString("title"));
            album.setArtistId(result.getInt("artist_id"));
            albums.add(album);
        }

        return albums;
    }
    public Set<Integer> getArtistAlbums(int artistId) throws SQLException {
        StringBuilder command = new StringBuilder("SELECT (album_id) FROM artists_albums WHERE artist_id = ").append(artistId).append(";");

        statement.executeQuery(command.toString());
        Set<Integer> albums = new HashSet<>();

        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            albums.add(resultSet.getInt("album_id"));
        }

        return albums;
    }


    public int saveTrack(Track track) throws SQLException{
        String command = String.format(
                "INSERT INTO tracks (title, album_id) VALUES ('%s', %d);",
                track.getTitle(),
                track.getAlbumId());
        statement.execute(command);
        int id = getLastInsertID("tracks");

        command = String.format(
                "INSERT INTO albums_tracks (album_id, track_id) VALUES (%d, %d);",
                track.getAlbumId(),
                id);
        statement.execute(command);

        for (Integer genreId : track.getGenres()) {
            command = String.format(
                    "INSERT INTO tracks_genres (track_id, genre_id) VALUES (%d, %d);",
                    id,
                    genreId);
            statement.execute(command);
        }

        return id;
    }

    public Track getTrack(Integer id) throws SQLException {
        StringBuilder s = new StringBuilder("SELECT * FROM tracks WHERE id = ").append(id).append(";");
        statement.executeQuery(s.toString());
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        Track track = new Track();
        track.setAlbumId(resultSet.getInt("album_id"));
        track.setId(resultSet.getInt("id"));
        track.setTitle(resultSet.getString("title"));
        return track;
    }
    public Set<Track> getTracks(String pattern) throws SQLException{
        if (null == pattern || 0 == pattern.length())
            pattern = "";
        else
            pattern = "WHERE " + pattern;

        StringBuilder command = new StringBuilder("SELECT * FROM tracks ").append(pattern).append(";");
        statement.executeQuery(command.toString());

        ResultSet result = statement.getResultSet();
        Set<Track> tracks = new HashSet<>();
        while (result.next()) {
            Track track = new Track();
            track.setId(result.getInt("id"));
            track.setTitle(result.getString("title"));
            track.setAlbumId(result.getInt("album_id"));
            tracks.add(track);
        }

        return tracks;
    }
    public Set<Integer> getAlbumTracks(int albumId) throws SQLException {
        StringBuilder command = new StringBuilder("SELECT (track_id) FROM albums_tracks WHERE album_id = ").append(albumId).append(";");

        statement.executeQuery(command.toString());
        Set<Integer> tracks = new HashSet<>();

        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            tracks.add(resultSet.getInt("track_id"));
        }

        return tracks;
    }
    public Set<Integer> getGenreTracks(int genreId) throws SQLException {
        StringBuilder command = new StringBuilder("SELECT (track_id) FROM tracks_genres WHERE genre_id = ").append(genreId).append(";");
        statement.executeQuery(command.toString());

        Set<Integer> tracks = new HashSet<>();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            tracks.add(resultSet.getInt("track_id"));
        }

        return tracks;
    }


    public int saveGenre(Genre genre) throws SQLException {
        String saveCommand = String.format(
                "INSERT INTO genres (name) VALUES ('%s');",
                genre.getName());
        statement.execute(saveCommand);
        int id = getLastInsertID("genres");
        return id;
    }

    public Genre getGenre(Integer id) throws SQLException {
        StringBuilder s = new StringBuilder("SELECT * FROM genres WHERE id = ").append(id).append(";");
        statement.executeQuery(s.toString());
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        Genre genre = new Genre();
        genre.setId(resultSet.getInt("id"));
        genre.setName(resultSet.getString("name"));
        return genre;
    }
    public Set<Genre> getGenres(String pattern) throws SQLException{
        if (null == pattern || 0 == pattern.length())
            pattern = "";
        else
            pattern = "WHERE " + pattern;

        StringBuilder command = new StringBuilder("SELECT * FROM genres ").append(pattern).append(";");
        statement.executeQuery(command.toString());

        ResultSet result = statement.getResultSet();
        Set<Genre> genres = new HashSet<>();
        while (result.next()) {
            Genre genre = new Genre();
            genre.setId(result.getInt("id"));
            genre.setName(result.getString("name"));
            genres.add(genre);
        }

        return genres;
    }
    public Set<Integer> getTrackGenres(int trackId) throws SQLException {
        StringBuilder command = new StringBuilder("SELECT (genre_id) FROM tracks_genres WHERE track_id = ").append(trackId).append(";");

        statement.executeQuery(command.toString());
        Set<Integer> genres = new HashSet<>();

        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            genres.add(resultSet.getInt("genre_id"));
        }

        return genres;
    }

}
