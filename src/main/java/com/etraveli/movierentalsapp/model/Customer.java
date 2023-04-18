package com.etraveli.movierentalsapp.model;

import lombok.Value;

import java.util.List;

/**
 * Customer name and his movieRentalsInfo
 *
 * @author Parasuram
 */
@Value
public class Customer {
    String name;
    List<MovieRental> movieRentals;

    public Customer(String name, List<MovieRental> movieRentals) {
        this.name = name;
        this.movieRentals = movieRentals;
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
