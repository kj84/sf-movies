package kj.movies.service.impl;

import kj.movies.dao.MoviesDao;
import kj.movies.dto.MovieDTO;
import kj.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karteek on 7/7/16.
 */
@Service
public class SFDataMoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesDao moviesDao;

    @Override
    public List<MovieDTO> getMovies() {
        return moviesDao.getMovies();
    }
}
