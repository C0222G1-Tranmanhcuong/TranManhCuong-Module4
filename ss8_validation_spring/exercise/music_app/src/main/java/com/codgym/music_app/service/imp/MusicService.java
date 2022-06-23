package com.codgym.music_app.service.imp;

import com.codgym.music_app.model.Music;
import com.codgym.music_app.repository.IMusicRepository;
import com.codgym.music_app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return iMusicRepository.findAll(pageable);
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAllMusic();
    }
}

