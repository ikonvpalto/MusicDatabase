# CREATE TABLE genres(
#   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
#   title VARCHAR(20)
# ) ENGINE = InnoDB;
#
#
# CREATE TABLE artists(
#   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE ,
#   title VARCHAR(20)
# ) ENGINE = InnoDB;
#
#
# CREATE TABLE albums(
#   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE ,
#   title VARCHAR(20),
#   artistId INT NOT NULL ,
#   FOREIGN KEY (artistId) REFERENCES artists(id)
# ) ENGINE = InnoDB;
#
#
# CREATE TABLE tracks(
#   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE ,
#   title VARCHAR(20),
#   album_id INT NOT NULL ,
#   FOREIGN KEY (album_id) REFERENCES albums(id)
# ) ENGINE = InnoDB;
#
#
# CREATE TABLE tracks_genres(
#   track_id INT,
#   genre_id INT,
#   UNIQUE (track_id, genre_id),
#   FOREIGN KEY (track_id) REFERENCES tracks(id),
#   FOREIGN KEY (genre_id) REFERENCES genres(id)
# ) ENGINE = InnoDB;
#
#
# CREATE TABLE albums_tracks(
#   album_id INT,
#   track_id INT UNIQUE,
#   FOREIGN KEY (album_id) REFERENCES albums(id),
#   FOREIGN KEY (track_id) REFERENCES tracks(id)
# ) ENGINE = InnoDB;
#
#
# CREATE TABLE artists_albums(
#   artistId INT,
#   album_id INT UNIQUE,
#   FOREIGN KEY (artistId) REFERENCES artists(id),
#   FOREIGN KEY (album_id) REFERENCES albums(id)
# ) ENGINE = InnoDB;
