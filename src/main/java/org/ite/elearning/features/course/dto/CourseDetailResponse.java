package org.ite.elearning.features.course.dto;

import org.ite.elearning.domain.Section;

import java.time.LocalDateTime;
import java.util.List;

public record CourseDetailResponse(
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

        List<Section> sections,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {
}
