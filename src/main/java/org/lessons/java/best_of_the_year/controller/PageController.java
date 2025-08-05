package org.lessons.java.best_of_the_year.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping("/home")
    public String greeting(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/song")
    public String song(Model model) {

        List<Song> songs = getBestSong();

        String songTitles = songs.stream()
                .map(Song::getTitle)
                .collect(Collectors.joining(",  "));

        model.addAttribute("songTitles", songTitles);
        return "song";
    }

    private List<Song> getBestSong() {
        return Arrays.asList(
                new Song("Call out my name", 1),
                new Song("Starboy", 2),
                new Song("Bene", 3),
                new Song("Non ti vedo più", 4));
    }

}