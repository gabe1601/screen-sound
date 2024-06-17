package com.example.alura.screensounds.model;

public class Artist {

    String name;
    Category artistType;

    public Artist(String name, Category artistType){
        this.name = name;
        this.artistType = artistType;
    }

    public String toString(){
        return "Nome: " + name
                + " / Tipo de artista: " + artistType;
    }

}
