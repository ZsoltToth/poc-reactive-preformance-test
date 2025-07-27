package eu.coeus.poc.performance.reactive.v1.business;

import eu.coeus.poc.performance.reactive.common.domain.Movie;
import eu.coeus.poc.performance.reactive.common.domain.exception.MovieNotFoundException;
import eu.coeus.poc.performance.reactive.common.mapper.MovieEntityMapper;
import eu.coeus.poc.performance.reactive.v1.data.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieEntityMapper mapper;
    @Override
    public Movie getMovie(int id) {
        return movieRepository.findById(id)
                .map(mapper::map)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }
}
