package com.etraveli.movierentalsapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Movies and its types
 * @author Parasuram
 */
@Getter
@AllArgsConstructor
public class Movie {
    public enum Type {
        CHILDRENS,
        REGULAR,
        NEW_RELEASE
    }

    private final String title;
    private final Type type;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null
                || this.getClass() != obj.getClass())
            return false;
        Movie movie = (Movie) obj;
        return this.title.equals(movie.title)
                && this.type == movie.type;
    }
}

