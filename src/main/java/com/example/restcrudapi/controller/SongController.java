package com.example.restcrudapi.controller;

import com.example.restcrudapi.dao.SongDAO;
import com.example.restcrudapi.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class SongController {

    private final SongDAO songDao;
    @Autowired
    public SongController(SongDAO songDao){
        this.songDao=songDao;
    }

    @GetMapping("/songs")
    public List<Song> showAllSongs(){
        return songDao.getAll();
    }

    @GetMapping("songs/{songid}")
    public Song getTheSong(@PathVariable int songid){
        Song theSong = songDao.getSongById(songid);
        return theSong;
    }

    @PostMapping("songs")
    public Song addSong(@RequestBody Song theSong){
        theSong.setId(0);
        songDao.save(theSong);
        return theSong;
    }

    @DeleteMapping("songs/{songid}")
      public String deleteSong(@PathVariable int songid){
          songDao.deleteById(songid);
          return"Deleted Song with id: " + songid;
      }

}
