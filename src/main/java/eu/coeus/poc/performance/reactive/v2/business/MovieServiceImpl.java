package eu.coeus.poc.performance.reactive.v2.business;

import eu.coeus.poc.performance.reactive.common.domain.Movie;
import eu.coeus.poc.performance.reactive.common.domain.exception.MovieNotFoundException;
import eu.coeus.poc.performance.reactive.common.mapper.MovieEntityMapper;
import eu.coeus.poc.performance.reactive.v1.data.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service("movieServiceImplV2")
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {


    private final MovieRepository movieRepository;
    private final MovieEntityMapper mapper;
    @Override
    public Mono<Movie> getMovie(Integer id) {
        return Mono.just(id)
                .map(movieRepository::findById)
                .map(movieEntity -> movieEntity.map(mapper::map)
                        .orElseThrow(()-> new MovieNotFoundException(id)));
    }
}
