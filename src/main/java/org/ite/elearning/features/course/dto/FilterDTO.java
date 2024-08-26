package org.ite.elearning.features.course.dto;

import org.springframework.web.bind.annotation.RequestParam;

public record FilterDTO(

        String filterAnd,

        String filterOr,

        String orders
) {
}
