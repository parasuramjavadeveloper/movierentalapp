package com.etraveli.movierentalsapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer name and his movieRentalsInfo
 *
 * @author Parasuram
 */
@Value
public class Customer {
    private final String name;
    private final List<MovieRental> movieRentals;

    public Customer(String name) {
        this.name = name;
        this.movieRentals = new ArrayList<>();
    }

    public void addMovieRental(MovieRental movieRental) {
        this.movieRentals.add(movieRental);
    }

}
