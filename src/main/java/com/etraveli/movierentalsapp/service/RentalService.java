package com.etraveli.movierentalsapp.service;

import com.etraveli.movierentalsapp.model.Customer;
import com.etraveli.movierentalsapp.model.MovieRental;
import com.etraveli.movierentalsapp.model.MovieType;

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
    private static final Map<MovieType, Double> PRICE_PER_DAY = new HashMap<>() {{
        put(MovieType.CHILDRENS, 1.5);
        put(MovieType.REGULAR, 2.0);
        put(MovieType.NEW_RELEASE, 3.0);
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
            if (Objects.equals(movieRental.getMovie().getMovieType().toString(), MovieType.NEW_RELEASE.toString())
                    && movieRental.getDaysRented() > 2)
                frequentEnterPoints++;

            rentByMovieTitle.put(movieRental.getMovie().getTitle(), thisAmount);
            totalAmount = totalAmount + thisAmount;
        }
        return new RentalStatement(customer, rentByMovieTitle, frequentEnterPoints);
    }

    private double movieRentalsAmount(MovieRental movieRental, double thisAmount) {
        if (movieRental.getMovie().getMovieType().equals(MovieType.REGULAR)) {
            thisAmount = PRICE_PER_DAY.get(MovieType.REGULAR);
            if (movieRental.getDaysRented() > 2) {
                thisAmount = ((movieRental.getDaysRented() - 2) * 1.5) + thisAmount;
            }
        }
        if (movieRental.getMovie().getMovieType().equals(MovieType.NEW_RELEASE)) {
            thisAmount = movieRental.getDaysRented() * PRICE_PER_DAY.get(MovieType.NEW_RELEASE);
        }
        if (movieRental.getMovie().getMovieType().equals(MovieType.CHILDRENS)) {
            thisAmount = PRICE_PER_DAY.get(MovieType.CHILDRENS);
            if (movieRental.getDaysRented() > 3) {
                thisAmount = ((movieRental.getDaysRented() - 3) * 1.5) + thisAmount;
            }
        }
        return thisAmount;
    }
}
