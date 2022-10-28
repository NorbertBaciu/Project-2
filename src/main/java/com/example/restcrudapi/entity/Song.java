package com.example.restcrudapi.entity;

import javax.persistence.*;

@Entity
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int songid;

    @Column(name="song_name")
    private String songName;

    @Column(name="song_artist")
    private String songArtist;

    @Column(name="album")
    private String album;

    @Column(name="song_time")
    private String songTime;

    public Song(){

    }
    public Song(String songName , String songArtist , String album , String songTime){
        this.songName=songName;
        this.songArtist=songArtist;
        this.album=album;
        this.songTime=songTime;
    }
    // Generate Getters and Setters

    public int getId() {
        return songid;
    }

    public void setId(int id) {
        this.songid = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSongTime() {
        return songTime;
    }

    public void setSongTime(String songTime) {
        this.songTime = songTime;
    }
}
