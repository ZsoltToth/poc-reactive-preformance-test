package eu.coeus.poc.performance.reactive.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record MovieResponse(
        String id,
        String title,
        double rank,
        String[] genres,
        String[] actors,
        String[] directors
) {

}
