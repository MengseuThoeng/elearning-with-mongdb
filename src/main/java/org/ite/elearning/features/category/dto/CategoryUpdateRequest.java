package org.ite.elearning.features.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryUpdateRequest(

        @NotBlank(message = "Name is required")
        String name
) {
}
