package com.first.helloapi;

import java.time.Instant;
import java.util.UUID;

public record UserFetchResponseDTO(
        UUID id,
        String firstName,
        String lastName,
        Instant dateCreated,
        Instant dateUpdated) {

}
