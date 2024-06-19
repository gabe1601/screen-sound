package com.example.alura.screensounds.repository;

import com.example.alura.screensounds.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Artist, Long> {

}
