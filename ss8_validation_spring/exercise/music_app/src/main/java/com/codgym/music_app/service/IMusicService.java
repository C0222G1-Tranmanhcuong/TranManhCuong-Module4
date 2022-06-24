package com.codgym.music_app.service;

import com.codgym.music_app.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMusicService {
    Page<Music> findAll(Pageable pageable);

    void save(Music music);

    List<Music> findAll();

    void update(Music music);

    Music findById(int id);
}
