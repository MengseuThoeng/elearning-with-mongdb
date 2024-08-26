package org.ite.elearning.features.course.dto;

import org.ite.elearning.domain.Video;

import java.util.List;

public record SectionCreateRequest (
        String title,

        Integer orderNo,

        List<Video> videos
){
}
