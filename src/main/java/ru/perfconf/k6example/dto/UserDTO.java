package ru.perfconf.k6example.dto;

import java.util.UUID;

public record UserDTO(
        UUID uuid,
        String name,
        Integer age
) {
}
