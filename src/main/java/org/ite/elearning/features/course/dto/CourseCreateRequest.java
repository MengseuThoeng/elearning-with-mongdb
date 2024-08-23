package org.ite.elearning.features.course.dto;

public record CourseCreateRequest(

        String title,

        String slug,

        String description,

        String thumbnail,

        Double price,

        String content,

        String categoryName
) {
}
