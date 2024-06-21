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

    public Music(String musicName, String album, String artistName){
        this.musicName = musicName;
        this.album = album;
        this.artistName = artist.getName();
    }

    public String toString (){
        return "Música: " + musicName
                + " / album: " + album
                + " / artista: " + artist;
    }
}
