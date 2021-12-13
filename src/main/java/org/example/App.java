package org.example;

import static org.example.Gender.FEMALE;
import static org.example.Gender.MALE;

public class App {
    public static void main( String[] args ) {
        ArtistDao artistdao = new ArtistDaoImpl();

        artistdao.createArtist(new Artist("Lowa","Vial",8,FEMALE, "Folkmusik"));
        artistdao.createArtist(new Artist("Albin","Dübech",25,MALE, "Death metal"));
        artistdao.createArtist(new Artist("Frege","Eriksson",24,MALE, "Psytrance"));
        artistdao.createArtist(new Artist("Tim","Bergling",28,FEMALE, "House"));
        artistdao.createArtist(new Artist("Miriam","Bryant",30,FEMALE, "Pop"));
        artistdao.selectAll().forEach(System.out::println);

        Artist a = artistdao.selectByID(4);
        a.setAge(27);
        a.setGender(MALE);
        artistdao.updateArtist(a);

        artistdao.selectAll().forEach(System.out::println);

    }
}
