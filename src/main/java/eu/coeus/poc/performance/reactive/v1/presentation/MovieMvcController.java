package eu.coeus.poc.performance.reactive.v1.presentation;

import eu.coeus.poc.performance.reactive.common.domain.Movie;
import eu.coeus.poc.performance.reactive.common.domain.exception.MovieNotFoundException;
import eu.coeus.poc.performance.reactive.common.dto.MovieResponse;
import eu.coeus.poc.performance.reactive.common.mapper.MovieMapper;
import eu.coeus.poc.performance.reactive.v1.business.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MovieMvcController {

    private final MovieService movieService;
    private final MovieMapper mapper;

    @GetMapping("/movies/{id}")
    public MovieResponse getMovieById(@PathVariable String id){
        try {
            Movie movie = movieService.getMovie(Integer.valueOf(id));
            return mapper.map(movie);
        } catch (NumberFormatException numberFormatException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie is is not Integer");
        }
        catch (MovieNotFoundException movieNotFoundException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie %s Not Found", movieNotFoundException.getMovieId()));
        }

    }
}
