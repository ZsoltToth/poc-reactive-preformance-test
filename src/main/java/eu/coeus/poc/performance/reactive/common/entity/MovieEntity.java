package eu.coeus.poc.performance.reactive.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class MovieEntity {


    @Id
    private Integer id;
    private String name;
    private Integer year;
    private Double rank;

    @ElementCollection
    @CollectionTable(
            name = "movies_genres",
            joinColumns = @JoinColumn(name="movie_id")

    )
    private Collection<String> genre;

    @ManyToMany
    @JoinTable(
            name = "roles",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id")
    )
    private Collection<ActorEntity> actors;

    @ManyToMany
    @JoinTable(
            name = "movies_directors",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="director_id")
    )
    private Collection<DirectorEntity> directors;

}
