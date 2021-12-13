package org.example;

import java.util.List;

public interface ArtistDao {
    void createArtist(Artist artist);
    void deleteArtist(Artist artist);
    Artist selectByID(int id);
    void updateArtist(Artist artist);
    List<Artist> selectAll();
    List<Artist> selectAllByGenre(String genre);
    List<Artist> selectAllByAge(int from, int to);
    List<Artist> selectAllByGender(Gender gender);
}
