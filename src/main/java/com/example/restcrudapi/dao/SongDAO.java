package com.example.restcrudapi.dao;

import com.example.restcrudapi.entity.Song;

import java.util.List;

public interface SongDAO {
    // Display all the data from the Db
    public List<Song> getAll();

    // Read a single song based on id
    public Song getSongById(int theId);

    // Save a song in the DB
    public void save(Song theSong);

    // Delete a song based on the id
    public void deleteById(int theId);


}
