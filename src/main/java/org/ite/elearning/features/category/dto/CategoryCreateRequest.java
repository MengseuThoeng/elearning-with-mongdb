package org.ite.elearning.features.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequest(

        @NotBlank(message = "Name is required")
        String name,

        String icon
) {
}
