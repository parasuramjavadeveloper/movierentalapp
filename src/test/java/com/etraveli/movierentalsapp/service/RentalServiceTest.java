package com.etraveli.movierentalsapp.service;

import com.etraveli.movierentalsapp.model.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.etraveli.movierentalsapp.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * RentalServiceTest used to test RentalService Property values such as Customer,RentByMovieTitle,FrequentEnterPoints and TotalRent per movie types
 *
 * @author Parasuram
 */
public class RentalServiceTest {

    @Test
    public void testToVerifyCustomer() {
        //Arrange and Act
        RentalStatement rentalStatement = new RentalService().statement(new Customer(SAMPLE_CUSTOMER_NAME, Collections.emptyList()));
        //Assert Given Customer returns or not
        assertEquals(SAMPLE_CUSTOMER_NAME, rentalStatement.getCustomer().getName());
    }

    @Test
    public void testRentByMovieTitle() {
        //Arrange and Act
        RentalStatement rentalStatement = getRentStatement();
        //Assert RentByMovieTitle
        assertEquals(expectedRentByMovieTitle(), rentalStatement.getRentByMovieTitle());
    }

    @Test
    public void testFrequentEnterPoints() {
        //Arrange and Act
        RentalStatement rentalStatement = getRentStatement();
        //Assert FrequentEnterPoints
        assertEquals(2, rentalStatement.getFrequentEnterPoints());
    }

    @Test
    public void testTotalRent() {
        //Arrange and Act
        RentalStatement rentalStatement = getRentStatement();
        //Assert TotalRent
        assertEquals(5.5, rentalStatement.getTotalRent());
    }


    @Test
    public void testTotalRentForNewMovies() {
        //Arrange
        final var movieRentals = List.of(new MovieRental(new Movie("RRR", MovieType.NEW_RELEASE), 3));
        // Act
        RentalStatement rentalStatement = new RentalService().statement(new Customer(SAMPLE_CUSTOMER_NAME, movieRentals));
        //Assert TotalRent
        assertEquals(9, rentalStatement.getTotalRent());
    }

    @Test
    public void testTotalRentForChildrenMovies() {
        //Arrange
        final var movieRentals = List.of(new MovieRental(new Movie("Hunden", MovieType.CHILDRENS), 5));
        //Act
        RentalStatement rentalStatement = new RentalService().statement(new Customer(SAMPLE_CUSTOMER_NAME, movieRentals));
        //Assert TotalRent
        assertEquals(4.5, rentalStatement.getTotalRent());
    }

    @Test
    public void testTotalRentForAllTypesOfMovies() {
        //Arrange
       final var movieRentals = List.of(new MovieRental(new Movie("Hunden", MovieType.CHILDRENS), 8),
                new MovieRental(new Movie("RRR", MovieType.NEW_RELEASE), 8),
                new MovieRental(new Movie("SIR", MovieType.REGULAR), 5));
        // Act
        RentalStatement rentalStatement = new RentalService().statement(new Customer(SAMPLE_CUSTOMER_NAME, movieRentals));
        //Assert TotalRent
        assertEquals(39.5, rentalStatement.getTotalRent());
    }

    private static RentalStatement getRentStatement() {
        return new RentalService().statement(getCustomer());
    }

    private static Customer getCustomer() {

        final var movieRentals = List.of(new MovieRental(new Movie(SAMPLE_MOVIE_TITLE, MovieType.REGULAR), 3),
                new MovieRental(new Movie(SAMPLE_MOVIE_TITLE_TWO, MovieType.REGULAR), 1));
        return new Customer(SAMPLE_CUSTOMER_NAME, movieRentals);
    }

    private HashMap<String, Double> expectedRentByMovieTitle() {
        final HashMap<String, Double> rentByMovieTitle = new HashMap<>();
        rentByMovieTitle.put(SAMPLE_MOVIE_TITLE, 3.5);
        rentByMovieTitle.put(SAMPLE_MOVIE_TITLE_TWO, 2.0);
        return rentByMovieTitle;
    }
}
