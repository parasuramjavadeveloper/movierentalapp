package com.etraveli.movierentalsapp.service;

import com.etraveli.movierentalsapp.model.Customer;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.etraveli.movierentalsapp.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * RentalStatementTest used to test RentalStatement Property values such as Customer,RentByMovieTitle and FrequentEnterPoints
 *
 * @author Parasuram
 */
public class RentalStatementTest {

    @Test
    public void testToVerifyCustomer() {
        //Arrange
        RentalStatement rentalStatement = new RentalStatement(new Customer(SAMPLE_CUSTOMER_NAME), new HashMap<>(), 0);
        //Act and Assert to check given Customer returns properly
        assertEquals(customer(), rentalStatement.getCustomer());
        assertEquals(SAMPLE_CUSTOMER_NAME, rentalStatement.getCustomer().getName());
    }

    @Test
    public void testRentByMovieTitle() {
        //Arrange
        RentalStatement rentalStatement = new RentalStatement(null, rentsByMovieTitle(), 0);
        //Act and Assert RentByMovieTitle
        assertEquals(expectedRentsByMovieTitle(), rentalStatement.getRentByMovieTitle());
    }

    @Test
    public void testFrequentEnterPoints() {
        //Arrange
        RentalStatement rentalStatement = new RentalStatement(null, new HashMap<>(), 5);
        //Assert FrequentEnterPoints
        assertEquals(5, rentalStatement.getFrequentEnterPoints());
    }

    @Test
    public void testCustomerRentalStatement() {
        //Arrange
        RentalStatement rentalStatement = new RentalStatement(new Customer(SAMPLE_CUSTOMER_NAME), rentByMovieTitle(), 5);
        //Assert FrequentEnterPoints
        assertEquals(5.5, rentalStatement.getTotalRent());
        assertEquals(5, rentalStatement.getFrequentEnterPoints());
        assertNotNull(rentalStatement.toString());
    }

    private HashMap<String, Double> rentByMovieTitle() {
        HashMap<String, Double> rentByMovieTitle = new HashMap<>();
        rentByMovieTitle.put(SAMPLE_MOVIE_TITLE, 3.5);
        rentByMovieTitle.put(SAMPLE_MOVIE_TITLE_TWO, 2.0);
        return rentByMovieTitle;
    }

    private HashMap<String, Double> rentsByMovieTitle() {
        HashMap<String, Double> rentByMovieTitle = new HashMap<>();
        rentByMovieTitle.put("Bahubali", 5.0);
        rentByMovieTitle.put("Pushpa", 3.0);
        return rentByMovieTitle;
    }

    private HashMap<String, Double> expectedRentsByMovieTitle() {
        HashMap<String, Double> rentByMovieTitle = new HashMap<>();
        rentByMovieTitle.put("Bahubali", 5.0);
        rentByMovieTitle.put("Pushpa", 3.0);
        return rentByMovieTitle;
    }

    private static Customer customer() {
        return new Customer(SAMPLE_CUSTOMER_NAME);
    }

}
