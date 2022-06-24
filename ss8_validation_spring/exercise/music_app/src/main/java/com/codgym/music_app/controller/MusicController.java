package com.codgym.music_app.controller;

import com.codgym.music_app.model.Music;
import com.codgym.music_app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Music> list = iMusicService.findAll(PageRequest.of(page, 1));
        model.addAttribute("musicList", list);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String addNew(@Valid @ModelAttribute("user") Music music,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("musicList", iMusicService.findAll());
            return "create";
        }
        iMusicService.save(music);
        model.addAttribute("msg", "Thêm mới thành công");
        return "result";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update( Music music) {
        iMusicService.update(music);
        return "redirect:/";
    }

}
