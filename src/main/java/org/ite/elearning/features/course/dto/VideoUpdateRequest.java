package org.ite.elearning.features.course.dto;

import org.ite.elearning.domain.Video;

import java.util.List;

public record VideoUpdateRequest(
        Integer sectionOrderNo,

        List<Video> videos
) {
}
