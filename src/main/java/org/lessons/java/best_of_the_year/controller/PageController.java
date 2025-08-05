package org.lessons.java.best_of_the_year.controller;

import java.util.Arrays;
import java.util.List;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("songs", songs);
        return "song";
    }

    @GetMapping("/song/{id}")
    public String getMethodName(@PathVariable int id, Model model) {
        List<Song> songs = getBestSong();

        Song song = songs.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (song != null) {
            model.addAttribute("title", song.getTitle());
        } else {
            model.addAttribute("title", "Canzone non trovata");
        }
        return "song-by-id";
    }

    @GetMapping("/movie")
    public String getMovies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);

        return "movie";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable int id, Model model) {
        List<Movie> movies = getBestMovies();

        Movie movie = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

        if (movie != null) {
            model.addAttribute("title", movie.getTitle());
        } else {
            model.addAttribute("title", "Film non trovato");
        }

        return "movie-by-id";
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