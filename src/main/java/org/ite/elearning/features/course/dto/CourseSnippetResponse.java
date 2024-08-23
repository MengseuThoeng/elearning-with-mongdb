package org.ite.elearning.features.course.dto;

import java.time.LocalDateTime;

public record CourseSnippetResponse(

        String id,

        String title,

        String slug,

        String description,

        String thumbnail,

        Double price,

        Double discount,

        String code,

        Boolean isPaid,

        Boolean isDraft,

        String instructorName,

        String categoryName,

        LocalDateTime createdAt,

        LocalDateTime updatedAt


) {
}
