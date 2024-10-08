package org.ite.elearning.features.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CourseCreateRequest(

        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Slug is required")
        String slug,

        String description,

        @NotBlank(message = "Thumbnail is required")
        String thumbnail,

        @Positive(message = "Price must be greater than 0")
        @NotNull(message = "Price is required")
        Double price,

        @NotBlank(message = "Content is required")
        String content,

        @NotBlank(message = "Category is required")
        String categoryName
) {
}
