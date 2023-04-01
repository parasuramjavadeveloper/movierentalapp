package com.etraveli.movierentalsapp.service;

import com.etraveli.movierentalsapp.model.Customer;
import com.etraveli.movierentalsapp.model.Movie;
import com.etraveli.movierentalsapp.model.MovieRental;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * RentalService has the business logic to generate the RentalStatement for the Customer Movies.
 * Customer is provided as an input with his movies which he  has taken for the rent
 * @author Parasuram
 */
public class RentalService {
    // Used to store Movie Types and its Day Price Per Day.
    private static final Map<Movie.Type, Double> PRICE_PER_DAY = new HashMap<>() {{
        put(Movie.Type.CHILDRENS, 1.5);
        put(Movie.Type.REGULAR, 2.0);
        put(Movie.Type.NEW_RELEASE, 3.0);
    }};

    /**
     * Takes the Customer as an Input and generates
     * the Movie RentalStatement of the given Customer
     * @param customer The Customer who wants to get his total movies rent for all the days.
     * @return RentalsStatement
     */
    public RentalStatement statement(Customer customer) {
        double totalAmount = 0;
        int frequentEnterPoints = 0;
        HashMap<String, Double> rentByMovieTitle = new HashMap<>();
        for (MovieRental movieRental : customer.getMovieRentals()) {
            double thisAmount = 0;
            thisAmount = movieRentalsAmount(movieRental, thisAmount);
            frequentEnterPoints++;
            if (Objects.equals(movieRental.getMovie().getType().toString(), Movie.Type.NEW_RELEASE.toString())
                    && movieRental.getDaysRented() > 2)
                frequentEnterPoints++;

            rentByMovieTitle.put(movieRental.getMovie().getTitle(), thisAmount);
            totalAmount = totalAmount + thisAmount;
        }
        return new RentalStatement(customer, rentByMovieTitle, frequentEnterPoints);
    }

    private double movieRentalsAmount(MovieRental movieRental, double thisAmount) {
        if (movieRental.getMovie().getType().equals(Movie.Type.REGULAR)) {
            thisAmount = PRICE_PER_DAY.get(Movie.Type.REGULAR);
            if (movieRental.getDaysRented() > 2) {
                thisAmount = ((movieRental.getDaysRented() - 2) * 1.5) + thisAmount;
            }
        }
        if (movieRental.getMovie().getType().equals(Movie.Type.NEW_RELEASE)) {
            thisAmount = movieRental.getDaysRented() * PRICE_PER_DAY.get(Movie.Type.NEW_RELEASE);
        }
        if (movieRental.getMovie().getType().equals(Movie.Type.CHILDRENS)) {
            thisAmount = PRICE_PER_DAY.get(Movie.Type.CHILDRENS);
            if (movieRental.getDaysRented() > 3) {
                thisAmount = ((movieRental.getDaysRented() - 3) * 1.5) + thisAmount;
            }
        }
        return thisAmount;
    }
}
