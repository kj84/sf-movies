package kj.movies.dao;

import kj.movies.dto.MovieDTO;

import java.util.List;

/**
 * Created by karteek on 7/7/16.
 */
public interface MoviesDao {

    public List<MovieDTO> getMovies();

}
