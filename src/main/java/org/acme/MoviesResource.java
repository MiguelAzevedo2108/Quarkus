package org.acme;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/movies")
public class MoviesResource extends MovieMapper{

    private MovieMapper movieMapper = new MovieMapper();

    @POST
    public Response createMovie(Movie movie)
    {
        return movieMapper.createMovie(movie);
    }

    @GET
    public Response getMovie()
    {
        return movieMapper.getMovie();
    }

    @GET
    @Path("/size")
    public int numberOfmovies()
    {
        return movieMapper.getNumberOfMovies();
    }

    @PUT
    @Path("/{id}")
    public Response updateMovie(@PathParam("id") String id, Movie newMovie)
    {
        return movieMapper.updateMovie(id,newMovie);
    }

   /* @DELETE
    @Path(("{id}"))
    public Response deleteMovie(@PathParam("id") String id)
    {
        for (int i = 0; i < moviesList.size(); i++) {
            if (moviesList.get(i).getId().equals(""+id)) {
                moviesList.remove(i);
            }
        }
        return Response.ok(moviesList).build();
    }*/
}