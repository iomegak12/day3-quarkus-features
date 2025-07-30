package com.learning.developers;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {

    public List<Movie> findByYear(int year) {
        return find("YEAR(releaseDate)", year).list();
    }

}
