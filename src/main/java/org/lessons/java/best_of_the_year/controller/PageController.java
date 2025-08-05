package org.lessons.java.best_of_the_year.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.lessons.java.best_of_the_year.classes.Movie;
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

    @GetMapping("/movie")
    public String getMovies(Model model) {
        List<Movie> movies = getBestMovies();

        String movieTitles = movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));

        model.addAttribute("movieTitles", movieTitles);

        return "movie";
    }

    private List<Movie> getBestMovies() {
        return Arrays.asList(
                new Movie("Inception", 1),
                new Movie("Interstellar", 2),
                new Movie("Matrix", 3),
                new Movie("Ratatouille", 4));
    }

    private List<Song> getBestSong() {
        return Arrays.asList(
                new Song("Call out my name", 1),
                new Song("Starboy", 2),
                new Song("Bene", 3),
                new Song("Non ti vedo più", 4));
    }

}