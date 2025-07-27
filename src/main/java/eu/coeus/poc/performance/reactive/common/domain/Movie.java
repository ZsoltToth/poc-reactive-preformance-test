package eu.coeus.poc.performance.reactive.common.domain;

import java.util.Collection;

public record Movie(
        int id,
        String title,
        double rank,
        Collection<Genre> genres,
        Collection<Actor> actors,
        Collection<Director> directors

) {
}
