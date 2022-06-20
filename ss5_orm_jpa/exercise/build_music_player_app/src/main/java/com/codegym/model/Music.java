package com.codegym.model;

import javax.persistence.*;

@Entity(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_music", columnDefinition = "INT")
    private Integer idMusic;
    @Column(name = "name_music")
    private String nameMusic;
    @Column(name = "name_singer")
    private String nameSinger;
    private String category;
    private String url;

    public Music() {
    }

    public Music(Integer idMusic,
                 String nameMusic,
                 String nameSinger,
                 String category,
                 String url) {
        this.idMusic = idMusic;
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.category = category;
        this.url = url;
    }

    public Integer getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(Integer idMusic) {
        this.idMusic = idMusic;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
