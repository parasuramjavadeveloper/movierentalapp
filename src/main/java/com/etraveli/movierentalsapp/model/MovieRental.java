package com.etraveli.movierentalsapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * MovieRental contains the movies and the daysRented them
 *
 * @author Parasuram
 */
@RequiredArgsConstructor
@Getter
public class MovieRental {
    private final Movie movie;
    private final int daysRented;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null
                || this.getClass() != obj.getClass())
            return false;
        MovieRental movieRental = (MovieRental) obj;
        return this.movie.equals(movieRental.movie)
                && this.daysRented == movieRental.daysRented;
    }

}
