package com.example.alura.screensounds.repository;

import com.example.alura.screensounds.model.Artist;
import com.example.alura.screensounds.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SoundRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String artist);

    @Query("SELECT m FROM Artist a JOIN a.musics m WHERE a.name ILIKE %:name% ORDER BY a.name ASC")
    List<Music> searchMusicByArtist(String name);

    @Query("SELECT m FROM Artist a JOIN a.musics m WHERE m.album ILIKE %:album% ORDER BY m.musicName ASC")
    List<Music> searchMusicsByAlbum(String album);

    @Query("SELECT m FROM Artist a JOIN a.musics m ORDER BY a.name")
    List<Music> findAllMusicsOrderedByArtistName();
}
