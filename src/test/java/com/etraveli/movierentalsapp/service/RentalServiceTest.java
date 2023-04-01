package com.etraveli.movierentalsapp.service;

import com.etraveli.movierentalsapp.model.Customer;
import com.etraveli.movierentalsapp.model.Movie;
import com.etraveli.movierentalsapp.model.MovieRental;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.etraveli.movierentalsapp.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * RentalServiceTest used to test RentalService Property values such as Customer,RentByMovieTitle,FrequentEnterPoints and TotalRent per movie types
 * @author Parasuram
 */
public class RentalServiceTest {

    @Test
    public void testToVerifyCustomer() {
        //Arrange and Act
        RentalStatement rentalStatement = new RentalService().statement(new Customer(SAMPLE_CUSTOMER_NAME));
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
        Customer customer = getCustomer();
        customer.getMovieRentals().clear();
        customer.addMovieRental(new MovieRental(new Movie("RRR", Movie.Type.NEW_RELEASE), 3));

        // Act
        RentalStatement rentalStatement = new RentalService().statement(customer);
        //Assert TotalRent
        assertEquals(9, rentalStatement.getTotalRent());
    }

    @Test
    public void testTotalRentForChildrenMovies() {
        //Arrange
        Customer customer = getCustomer();
        customer.getMovieRentals().clear();
        customer.addMovieRental(new MovieRental(new Movie("Hunden", Movie.Type.CHILDRENS), 5));

        //Act
        RentalStatement rentalStatement = new RentalService().statement(customer);
        //Assert TotalRent
        assertEquals(4.5, rentalStatement.getTotalRent());
    }

    @Test
    public void testTotalRentForAllTypesOfMovies() {
        //Arrange
        Customer customer = getCustomer();
        customer.getMovieRentals().clear();
        customer.addMovieRental(new MovieRental(new Movie("Hunden", Movie.Type.CHILDRENS), 8));
        customer.addMovieRental(new MovieRental(new Movie("RRR", Movie.Type.NEW_RELEASE), 8));
        customer.addMovieRental(new MovieRental(new Movie("SIR", Movie.Type.REGULAR), 5));

        //Act
        RentalStatement rentalStatement = new RentalService().statement(customer);
        //Assert TotalRent
        assertEquals(39.5, rentalStatement.getTotalRent());
    }

    private static RentalStatement getRentStatement() {
        RentalStatement rentalStatement = new RentalService().statement(getCustomer());
        return rentalStatement;
    }

    private static Customer getCustomer() {
        Customer customers = new Customer(SAMPLE_CUSTOMER_NAME);
        customers.addMovieRental(new MovieRental(new Movie(SAMPLE_MOVIE_TITLE, Movie.Type.REGULAR), 3));
        customers.addMovieRental(new MovieRental(new Movie(SAMPLE_MOVIE_TITLE_TWO, Movie.Type.REGULAR), 1));
        return customers;
    }

    private HashMap<String, Double> expectedRentByMovieTitle() {
        final HashMap<String, Double> rentByMovieTitle = new HashMap<>();
        rentByMovieTitle.put(SAMPLE_MOVIE_TITLE, 3.5);
        rentByMovieTitle.put(SAMPLE_MOVIE_TITLE_TWO, 2.0);
        return rentByMovieTitle;
    }
}
