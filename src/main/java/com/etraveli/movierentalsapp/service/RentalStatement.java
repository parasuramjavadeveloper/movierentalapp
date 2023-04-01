package com.etraveli.movierentalsapp.service;

import com.etraveli.movierentalsapp.model.Customer;
import com.etraveli.movierentalsapp.model.MovieRental;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

/**
 * RentStatement generates the MovieRentalSlip for the given customers.
 * It gives the TotalRent for all the customer movies and its Bonus Points.
 *
 * @author Parasuram
 */
@Getter
@AllArgsConstructor
public class RentalStatement {
    private final Customer customer;
    private final HashMap<String, Double> rentByMovieTitle;
    private final int frequentEnterPoints;

    /**
     * Calculate the total-rent of all the customer movies for all the days.
     *
     * @return Returns the TotalRent of all customer movies.
     */
    public double getTotalRent() {
        return rentByMovieTitle.values().stream().mapToDouble(v -> v).sum();
    }

    @Override
    public String toString() {
        StringBuilder formattedStatement = new StringBuilder();
        formattedStatement.append("Rental record for customer : ").append(customer.getName()).append("\n\n");
        formattedStatement.append(String.format("%-20s", "Movie Title"))
                .append("|")
                .append(String.format(" %-20s", "Movie Rent"))
                .append("\n");
        formattedStatement.append("--------------------------------").append("\n");
        for (MovieRental movieRental : customer.getMovieRentals()) {
            String movieTitle = movieRental.getMovie().getTitle();
            formattedStatement.append(String.format("%-20s", movieTitle))
                    .append("|")
                    .append(String.format(" %-20s", rentByMovieTitle.get(movieTitle))).append("\n");
        }
        formattedStatement.append("\n\n");
        formattedStatement.append("Total Rent         : ").append(getTotalRent()).append("\n");
        formattedStatement.append("Total Bonus Earned : ").append(getFrequentEnterPoints());
        return formattedStatement.toString();
    }
}
