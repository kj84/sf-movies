package kj.movies.controller;

import kj.movies.dto.MovieDTO;
import kj.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by karteek on 7/7/16.
 */
@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @RequestMapping(path = "/movies")
    public List<MovieDTO> getMovies() {
        return moviesService.getMovies();
    }
}
