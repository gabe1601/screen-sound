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
    private String artistName;
    @ManyToOne
    private Artist artist;

    public Music(){
    }

    public Music(String musicName, String album, String artistName){
        this.musicName = musicName;
        this.album = album;
        this.artistName = artistName;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getAlbum() {
        return album;
    }

    public String toString (){
        return "Música: " + musicName
                + " / album: " + album
                + " / artista: " + artistName;
    }
}
