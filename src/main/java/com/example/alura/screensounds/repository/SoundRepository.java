package com.example.alura.screensounds.repository;

import com.example.alura.screensounds.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoundRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String artist);
}
