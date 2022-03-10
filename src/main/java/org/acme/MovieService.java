package org.acme;

import javax.ws.rs.core.Response;
import java.util.Set;

public class MovieService {

    public Response addMovie(Set<Movie> moviesList, Movie newMovie)
    {
        moviesList.add(newMovie);
        return Response.ok(moviesList).build();
    }

    public int getAllMovies(Set<Movie> moviesList)
    {
        return moviesList.size();
    }

    public Movie newMovieToMovie(Movie newMovie, Movie movie)
    {
        movie.setId(newMovie.getId());
        movie.setName(newMovie.getName());
        movie.setDuration(newMovie.getDuration());
        movie.setRating(newMovie.getRating());

        return movie;
    }


}
