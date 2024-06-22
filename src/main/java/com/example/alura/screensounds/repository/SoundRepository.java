package com.example.alura.screensounds.repository;

import com.example.alura.screensounds.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SoundRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String artist);

    List<Artist> findMusicByIdEquals(Long aLong);

    @Query("SELECT m FROM Musica m")
}
