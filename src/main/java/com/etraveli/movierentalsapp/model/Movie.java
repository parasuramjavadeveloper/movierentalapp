package com.etraveli.movierentalsapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

/**
 * Movies and its types
 *
 * @author Parasuram
 */
@Data
@AllArgsConstructor
public class Movie {
    private String title;
    private MovieType movieType;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null
                || this.getClass() != obj.getClass())
            return false;
        Movie movie = (Movie) obj;
        return this.title.equals(movie.title)
                && this.movieType == movie.movieType;
    }

}

