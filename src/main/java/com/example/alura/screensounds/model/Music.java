package com.example.alura.screensounds.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String musicName;
    private String album;
    @ManyToOne
    private Artist artistName;

    public Music(){
    }

    public Music(String musicName, String album, Artist artistName){
        this.musicName = musicName;
        this.album = album;
        this.artistName = artistName;
    }

    public Artist getArtistName() {
        return artistName;
    }

    public void setArtistName(Artist artistName) {
        this.artistName = artistName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString (){
        return "Música: " + musicName
                + " / album: " + album
                + " / artista: " + artistName;
    }
}
