package com.learning.developers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface SwapiService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/films/{id}")
    public Swapi getFilmById(@PathParam("id") String id);
}
