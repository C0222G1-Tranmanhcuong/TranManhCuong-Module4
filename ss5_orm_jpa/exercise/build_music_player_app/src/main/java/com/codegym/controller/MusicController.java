package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String home(Model model) {
        List<Music> musicList = iMusicService.findAll();
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String save(Music music) {
        iMusicService.save(music);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Music music) {
        iMusicService.update(music);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id) {
        iMusicService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchList (@RequestParam("name") String name, Model model){
        List<Music> music = iMusicService.searchByName(name);
        model.addAttribute("musicList",music);
        return "list";
    }
}
