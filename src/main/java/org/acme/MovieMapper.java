package org.acme;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieMapper extends MovieService{

    private MovieService movieService = new MovieService();

    public Set<Movie> moviesList = new HashSet<>();

    public Response createMovie (Movie movie)
    {
        return movieService.addMovie(moviesList,movie);
    }

    public Response getMovie()
    {
        return Response.ok(moviesList).build();
    }

    public int getNumberOfMovies()
    {
        return movieService.getAllMovies(moviesList);
    }

    public Response updateMovie(String id, Movie newMovie)
    {
        moviesList.stream()
                .filter(movie -> movie.getId().equals(id))
                .map(movie -> movieService.newMovieToMovie(newMovie, movie))
                .collect(Collectors.toList());
        return Response.ok(moviesList).build();
    }
}
