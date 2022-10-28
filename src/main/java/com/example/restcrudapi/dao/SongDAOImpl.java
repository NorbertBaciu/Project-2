package com.example.restcrudapi.dao;

import com.example.restcrudapi.entity.Song;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SongDAOImpl implements SongDAO{

    private final EntityManager entityManager;

    @Autowired
    public SongDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public List<Song> getAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Song> theQuery = currentSession.createQuery("from Song" , Song.class);
        List<Song> songs = theQuery.getResultList();
        return songs;
    }

    @Override
    @Transactional
    public Song getSongById(int theId){
        // get the Current Hibernate Session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the Song
        Song theSong = currentSession.get(Song.class , theId);

        return theSong;
    }

    @Override
    @Transactional
    public void save(Song theSong){
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theSong); // if id=0 then save/insert , else update
    }

    @Override
    @Transactional
    public void deleteById(int theId){
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Song where id=:songid");
        theQuery.setParameter("songid" , theId);
        theQuery.executeUpdate();

    }
}
