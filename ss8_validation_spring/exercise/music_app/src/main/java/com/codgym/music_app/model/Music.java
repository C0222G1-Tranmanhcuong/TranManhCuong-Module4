package com.codgym.music_app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_music")
    private Integer idMusic;
    @Column(name = "name_music")
    @NotBlank(message = "Không để trống trường này")
    @Size(max = 800,message = "Không vượt qua 800 kí tự")
    @Pattern(regexp = "^[A-Za-z ]+$")
    private String nameMusic;
    @Column(name = "name_singer")
    @NotBlank(message = "Không để trống trường này")
    @Size(max = 300,message = "Không vượt qua 300 kí tự")
    @Pattern(regexp = "^[A-Za-z ]+$")
    private String nameSinger;
    @NotBlank(message = "Không để trống trường này")
    @Size(max = 1000,message = "Không vượt qua 1000 kí tự")
    @Pattern(regexp = "^[A-Za-z, ]+$")
    private String category;

    public Music() {
    }

    public Music(Integer idMusic, @NotBlank(message = "Không để trống trường này") @Size(max = 800,
            message = "Không vượt qua 800 kí tự") @Pattern(regexp = "^[A-Za-z ]+$") String nameMusic,
                 @NotBlank(message = "Không để trống trường này") @Size(max = 300, message = "Không vượt qua 300 kí tự")
                 @Pattern(regexp = "^[A-Za-z ]+$") String nameSinger, @NotBlank(message = "Không để trống trường này")
                 @Size(max = 1000, message = "Không vượt qua 1000 kí tự")
                 @Pattern(regexp = "^[A-Za-z, ]+$") String category) {
        this.idMusic = idMusic;
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.category = category;
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
}
