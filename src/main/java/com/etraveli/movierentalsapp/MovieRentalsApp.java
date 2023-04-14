package com.etraveli.movierentalsapp;

import com.etraveli.movierentalsapp.model.Customer;
import com.etraveli.movierentalsapp.model.Movie;
import com.etraveli.movierentalsapp.model.MovieRental;
import com.etraveli.movierentalsapp.model.MovieType;
import com.etraveli.movierentalsapp.service.RentalService;

/**
 * MovieRentalsApp Designed to know the Customer Movies Rental Information.
 *
 * @author Parasuram
 */
public class MovieRentalsApp {

    public static void main(String[] args) {
        final var customers = new Customer("C. U. Stomer");
        customers.addMovieRental(new MovieRental(new Movie("You've Got Mail", MovieType.REGULAR), 3));
        customers.addMovieRental(new MovieRental(new Movie("Matrix", MovieType.REGULAR), 1));
        System.out.println(new RentalService().statement(customers));
    }
}
