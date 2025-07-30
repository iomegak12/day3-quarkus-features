package com.learning.developers;

import jakarta.ws.rs.*;
import org.eclipse.microprofile.faulttolerance.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient
public interface SwapiService {
    @GET
    @Path("/films/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 2000L)
    @Fallback(SwapiFallback.class)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = .5, delay = 5000L, successThreshold = 2)
    public Swapi getFilmById(@PathParam("id") String id);

    public static class SwapiFallback implements FallbackHandler<Swapi> {

        private static final Swapi EMPTY_SWAPI = new Swapi("", 0, "", "", "");

        @Override
        public Swapi handle(ExecutionContext context) {
            return EMPTY_SWAPI;
        }

    }
}