package server;

public class Server {

    public static void main(String... args) {
        ServerInterface serverInterface = new ServerInterface();
        try {
//            Artist artist = new Artist("balda");
//            Album album = new Album("gorgorod");
//            Track track = new Track("hui");
//            Genre genre = new Genre("rock");
//            album.setArtistId(DBInterface.getInstance().saveArtist(artist));
//            track.setAlbumId(DBInterface.getInstance().saveAlbum(album));
//            DBInterface.getInstance().saveTrack(track);
//            DBInterface.getInstance().saveGenre(genre);

            //TODO: for Julia

            System.out.println("\n\nArtist:");
            DBInterface.getInstance().getArtists("").forEach(System.out::println);
            System.out.println(DBInterface.getInstance().getArtist(5));

            System.out.println("\n\nAlbum:");
            DBInterface.getInstance().getAlbums("").forEach(System.out::println);
            System.out.println(DBInterface.getInstance().getAlbum(4));
            DBInterface.getInstance().getArtistAlbums(5).forEach(System.out::println);

            System.out.println("\n\nTracks:");
            DBInterface.getInstance().getTracks("").forEach(System.out::println);
            System.out.println(DBInterface.getInstance().getTrack(2));
            DBInterface.getInstance().getAlbumTracks(4).forEach(System.out::println);
            DBInterface.getInstance().getGenreTracks(2).forEach(System.out::println);

            System.out.println("\n\nGenres:");
            DBInterface.getInstance().getGenres("").forEach(System.out::println);
            System.out.println(DBInterface.getInstance().getGenre(2));
            DBInterface.getInstance().getTrackGenres(2).forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
