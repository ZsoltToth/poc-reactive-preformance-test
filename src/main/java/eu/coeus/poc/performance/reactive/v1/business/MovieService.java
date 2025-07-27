package eu.coeus.poc.performance.reactive.v1.business;

import eu.coeus.poc.performance.reactive.common.domain.Movie;

public interface MovieService {

    Movie getMovie(int id);
}
