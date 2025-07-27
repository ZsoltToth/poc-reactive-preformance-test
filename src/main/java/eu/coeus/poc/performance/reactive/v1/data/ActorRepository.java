package eu.coeus.poc.performance.reactive.v1.data;

import eu.coeus.poc.performance.reactive.common.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {
}
