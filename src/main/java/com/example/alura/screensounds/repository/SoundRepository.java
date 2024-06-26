package com.example.alura.screensounds.repository;

import com.example.alura.screensounds.model.Artist;
import com.example.alura.screensounds.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SoundRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String artist);

    @Query("SELECT m FROM Artist a JOIN a.musics m WHERE a.name ILIKE %:name")
    List<Music> searchMusicByArtist(String name);
}
