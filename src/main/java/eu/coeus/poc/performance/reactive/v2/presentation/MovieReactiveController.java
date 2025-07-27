package eu.coeus.poc.performance.reactive.v2.presentation;

import eu.coeus.poc.performance.reactive.common.domain.Movie;
import eu.coeus.poc.performance.reactive.common.domain.exception.MovieNotFoundException;
import eu.coeus.poc.performance.reactive.common.dto.MovieResponse;
import eu.coeus.poc.performance.reactive.common.mapper.MovieMapper;
import eu.coeus.poc.performance.reactive.v2.business.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v2")
@RequiredArgsConstructor
public class MovieReactiveController {

    private final MovieService movieService;
    private final MovieMapper mapper;

    @GetMapping("/movies/{id}")
    public Mono<MovieResponse> getMovieById(@PathVariable String id){
        return movieService.getMovie(Integer.valueOf(id))
                .map(mapper::map);
    }
}
