package com.etraveli.movierentalsapp.model;

import lombok.Value;

/**
 * Movies and its types
 *
 * @author Parasuram
 */
@Value
public class Movie {
    private final String title;
    private final MovieType movieType;

}

