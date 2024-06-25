package com.example.alura.screensounds.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Music> musics = new ArrayList<>();

    public Artist() {
    }

    public Artist(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public List<Music> getMusics() {
        return musics;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return "Nome: " + name
                + " / Tipo de artista: " + category
                + " / Musica: " + musics;
    }

}
