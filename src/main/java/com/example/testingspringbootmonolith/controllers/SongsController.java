package com.example.testingspringbootmonolith.controllers;

import com.example.testingspringbootmonolith.models.Song;
import com.example.testingspringbootmonolith.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SongsController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/songs")
    public Iterable<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/songs/{songId}")
    public Optional<Song> findSongById(@PathVariable Long songId) {
        return songRepository.findById(songId);
    }

    @DeleteMapping("/songs/{songId}")
    public HttpStatus deleteSongById(@PathVariable Long songId) {
        songRepository.deleteById(songId);
        return HttpStatus.OK;
    }

    @PostMapping("/songs")
    public Song createNewSong(@RequestBody Song newSong) {
        return songRepository.save(newSong);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSongById(@PathVariable Long songId, @RequestBody Song songRequest) {
        Song songFromDB = songRepository.findById(songId).get();

        songFromDB.setArtist(songRequest.getArtist());
        songFromDB.setSongLength(songRequest.getSongLength());
        songFromDB.setTitle(songRequest.getTitle());

        return songRepository.save(songFromDB);
    }
}
