package eu.coeus.poc.performance.reactive.common.mapper;

import eu.coeus.poc.performance.reactive.common.domain.Actor;
import eu.coeus.poc.performance.reactive.common.domain.Director;
import eu.coeus.poc.performance.reactive.common.domain.Genre;
import eu.coeus.poc.performance.reactive.common.domain.Movie;
import eu.coeus.poc.performance.reactive.common.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class MovieEntityMapper {

    @Mapping(target = "title", source = "name")
    @Mapping(target = "genres", source = ".")
    @Mapping(target = "actors", source = ".")
    @Mapping(target = "directors", source = ".")
    public abstract Movie map(MovieEntity entity);

    protected Collection<Genre> mapGenres(MovieEntity entity){
        return Optional.ofNullable(entity.getGenre())
                .map(genres -> genres.stream().map(Genre::new).toList())
                .orElse(List.of());
    }

    protected Collection<Actor> mapActors(MovieEntity entity){
        return Optional.ofNullable(entity.getActors())
                .map(actors -> actors.stream().map(
                        actor -> new Actor(actor.getFirstName(), actor.getLastName())
                        ).toList()
                ).orElse(List.of());
    }
    protected Collection<Director> mapDirectors(MovieEntity entity){
        return Optional.ofNullable(entity.getDirectors())
                .map(directors -> directors.stream().map(
                                director -> new Director(director.getFirstName(), director.getLastName())
                        ).toList()
                ).orElse(List.of());
    }


}
