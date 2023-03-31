package com.etraveli.movierentalsapp;

import com.etraveli.movierentalsapp.model.Customer;
import com.etraveli.movierentalsapp.model.Movie;
import com.etraveli.movierentalsapp.model.MovieRental;
import com.etraveli.movierentalsapp.service.RentalStatement;
import com.etraveli.movierentalsapp.service.RentalService;

/**
 * MovieRentalsApp Designed to know the Customer Movies Rental Information.
 *
 * @author Parasuram
 */
public class MovieRentalsApp {

    public static void main(String[] args) {
        Customer customers = new Customer("C. U. Stomer");
        customers.addMovieRental(new MovieRental(new Movie("You've Got Mail", Movie.Type.REGULAR), 3));
        customers.addMovieRental(new MovieRental(new Movie("Matrix", Movie.Type.REGULAR), 1));
        RentalStatement rentalStatement = new RentalService().statement(customers);
        System.out.println(rentalStatement);
    }
}
