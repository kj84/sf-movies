package kj.movies.dao.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import kj.movies.dao.MoviesDao;
import kj.movies.dto.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by karteek on 7/7/16.
 */
@Repository
public class SFDataMoviesDao implements MoviesDao {

    public static final String MOVIES_URL = "https://data.sfgov.org/resource/wwmu-gmzc.json";

    @Override
    public List<MovieDTO> getMovies() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MovieWSDTO[]> moviesResponse =
                restTemplate.getForEntity(MOVIES_URL, MovieWSDTO[].class);

        MovieWSDTO[] moviesWS = moviesResponse.getBody();

        List<MovieDTO> movies = new ArrayList<>();
        Arrays.stream(moviesWS)
                .forEach(m -> movies.add(m.convert()));

        return movies;
    }


    private static class MovieWSDTO {

        @JsonProperty("actor_1")
        private String actor1;

        @JsonProperty("actor_2")
        private String actor2;

        @JsonProperty("actor_3")
        private String actor3;

        private String director;

        private String locations;

        @JsonProperty("production_company")
        private String productionCompany;

        @JsonProperty("release_year")
        private int releaseYear;

        private String title;

        private String writer;

        private String distributor;

        public MovieDTO convert() {
            MovieDTO movie = new MovieDTO();
            movie.setActors(new ArrayList<>());
            if(!StringUtils.isEmpty(actor1)) {
                movie.getActors().add(actor1);
            }
            if(!StringUtils.isEmpty(actor2)) {
                movie.getActors().add(actor2);
            }
            if(!StringUtils.isEmpty(actor3)) {
                movie.getActors().add(actor3);
            }

            movie.setDirector(director);
            movie.setLocations(locations);
            movie.setProductionCompany(productionCompany);
            movie.setReleaseYear(releaseYear);
            movie.setTitle(title);
            movie.setWriter(writer);
            movie.setDistributor(distributor);
            return movie;
        }

        @JsonProperty("fun_facts")
        private String funFacts;

        public String getActor1() {
            return actor1;
        }

        public void setActor1(String actor1) {
            this.actor1 = actor1;
        }

        public String getActor2() {
            return actor2;
        }

        public void setActor2(String actor2) {
            this.actor2 = actor2;
        }

        public String getActor3() {
            return actor3;
        }

        public void setActor3(String actor3) {
            this.actor3 = actor3;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getLocations() {
            return locations;
        }

        public void setLocations(String locations) {
            this.locations = locations;
        }

        public String getProductionCompany() {
            return productionCompany;
        }

        public void setProductionCompany(String productionCompany) {
            this.productionCompany = productionCompany;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getWriter() {
            return writer;
        }

        public void setWriter(String writer) {
            this.writer = writer;
        }

        public String getDistributor() {
            return distributor;
        }

        public void setDistributor(String distributor) {
            this.distributor = distributor;
        }

        public String getFunFacts() {
            return funFacts;
        }

        public void setFunFacts(String funFacts) {
            this.funFacts = funFacts;
        }
    }
}
