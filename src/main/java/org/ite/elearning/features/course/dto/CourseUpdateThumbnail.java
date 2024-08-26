package org.ite.elearning.features.course.dto;

import jakarta.validation.constraints.NotBlank;

public record CourseUpdateThumbnail(

        @NotBlank(message = "Thumbnail is required")
        String thumbnail

) {
}
