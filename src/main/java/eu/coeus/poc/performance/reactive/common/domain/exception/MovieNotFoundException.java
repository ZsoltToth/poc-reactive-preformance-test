package eu.coeus.poc.performance.reactive.common.domain.exception;

import lombok.Getter;

@Getter
public class MovieNotFoundException extends RuntimeException {

    private final int movieId;

    public MovieNotFoundException(int movieId) {
        this.movieId = movieId;
    }
}
