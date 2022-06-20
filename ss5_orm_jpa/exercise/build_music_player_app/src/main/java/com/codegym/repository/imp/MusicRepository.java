package com.codegym.repository.imp;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    private static List<Music> musicList = new ArrayList<>();

    @Override
    public List<Music> findAll() {
        List<Music> music = BaseRepository.entityManager.createQuery("select m from music m", Music.class).getResultList();
        return music;
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        Music music = BaseRepository.entityManager.createQuery("select m from music m where id = ?1", Music.class).setParameter(1, id).getSingleResult();
        return music;
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Music music = findById(id);
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }

    @Override
    public List<Music> searchByName(String name) {
        String search = "select m from music m where m.nameMusic Like ?1";
        List<Music> music = BaseRepository.entityManager.createQuery(search, Music.class).setParameter(1, "%" + name + "%").getResultList();
        return music;
    }
}
