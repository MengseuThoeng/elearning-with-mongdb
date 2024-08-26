package org.ite.elearning.features.course.dto;

public record VideoCreateRequest(
        Integer sectionOrderNo,

        String lectureNo,

        Integer orderNo,

        String title,

        String fileName
) {
}
