package com.learning.developers;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Path("movie")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    @RestClient
    @Inject
    SwapiService swapiService;

    @GET
    public List<MovieDTO> getMovie(@QueryParam("year") String year) {

        if (year != null) {
            return Movie.findByYear(Integer.parseInt(year)).stream()
                    .map(movie -> MovieDTO.of(movie, swapiService.getFilmById(String.valueOf(movie.id))))
                    .collect(Collectors.toList());
        } else {
            return Movie.<Movie>listAll().stream()
                    .map(movie -> MovieDTO.of(movie, swapiService.getFilmById(String.valueOf(movie.id))))
                    .collect(Collectors.toList());
        }

    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newMovie(Movie movie) {
        movie.id = null;
        movie.persist();
        return Response.status(Response.Status.CREATED).entity(movie).build();
    }
}