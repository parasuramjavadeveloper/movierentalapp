package com.etraveli.movierentalsapp.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer name and his movieRentalsInfo
 *
 * @author Parasuram
 */
@Data
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null
                || this.getClass() != obj.getClass())
            return false;
        Customer customer = (Customer) obj;
        return this.name.equals(customer.name)
                && this.movieRentals.equals(customer.movieRentals);
    }
}
