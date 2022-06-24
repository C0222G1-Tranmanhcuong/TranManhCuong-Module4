package com.codgym.music_app.repository;

import com.codgym.music_app.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMusicRepository extends JpaRepository<Music, Integer> {

    @Modifying
    @Query(value = "insert into music(name_music,name_singer,category) value(:name_music,:name_singer,:category) ", nativeQuery = true)
    void save(@Param("name_music") String nameMusic, @Param("name_singer") String nameSinger, @Param("category") String category);

    @Query(value = "select * from music", nativeQuery = true)
    Page<Music> findAllMusic(Pageable pageable);

    @Query(value = "select * from music", nativeQuery = true)
    List<Music> findAllMusic();

    @Modifying
    @Query(value = "update music set name_music= :name_music,name_singer=:name_singer, category =:category where id_music =:id", nativeQuery = true)
    void update(@Param("name_music") String nameMusic, @Param("name_singer") String nameSinger, @Param("category") String category, @Param("id") Integer id);

    @Query(value = " select  * from music where id_music = :id", nativeQuery = true)
    Music findById(@Param("id") int id);
}
