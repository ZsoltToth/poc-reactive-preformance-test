package eu.coeus.poc.performance.reactive.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actors")
public class ActorEntity {

    @Id
    private  int id;
    private char gender;
    private String firstName;
    private String lastName;
}
