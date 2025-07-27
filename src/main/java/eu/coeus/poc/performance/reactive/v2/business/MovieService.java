package eu.coeus.poc.performance.reactive.v2.business;

import eu.coeus.poc.performance.reactive.common.domain.Movie;
import reactor.core.publisher.Mono;

public interface MovieService {

    Mono<Movie> getMovie(Integer id);
}
