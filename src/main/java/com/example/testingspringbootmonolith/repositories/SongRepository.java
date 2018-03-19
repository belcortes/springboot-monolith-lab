package com.example.testingspringbootmonolith.repositories;

import com.example.testingspringbootmonolith.models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long>{
}
