package com.etraveli.movierentalsapp.model;

import lombok.Value;

/**
 * MovieRental contains the movies and the daysRented them
 *
 * @author Parasuram
 */
@Value
public class MovieRental {
    Movie movie;
    int daysRented;
}
