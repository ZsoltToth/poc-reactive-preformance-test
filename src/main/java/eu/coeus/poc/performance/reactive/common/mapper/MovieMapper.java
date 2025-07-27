package eu.coeus.poc.performance.reactive.common.mapper;

import eu.coeus.poc.performance.reactive.common.domain.Actor;
import eu.coeus.poc.performance.reactive.common.domain.Director;
import eu.coeus.poc.performance.reactive.common.domain.Genre;
import eu.coeus.poc.performance.reactive.common.domain.Movie;
import eu.coeus.poc.performance.reactive.common.dto.MovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {


//    @Mapping(target = "id", source = "id")
    public abstract MovieResponse map(Movie movie);

    protected String[] mapGenres(Collection<Genre> genres){
        return genres.stream()
                .map(Genre::genre)
                .toList()
                .toArray(new String[genres.size()]);
    }

    protected String[] mapActors(Collection<Actor> actors){
        return (String[]) actors.stream()
                .map(actor -> String.format("%s %s", actor.firstName(), actor.lastName()))
                .toList()
                .toArray(new String[actors.size()]);
    }

    protected String[] mapDirectors(Collection<Director> directors){
        return (String[]) directors.stream()
                .map(director -> String.format("%s %s", director.firstName(), director.lastName()))
                .toList()
                .toArray(new String[directors.size()]);
    }
}
