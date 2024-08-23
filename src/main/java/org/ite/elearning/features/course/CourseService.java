package org.ite.elearning.features.course;

import org.ite.elearning.features.course.dto.CourseCreateRequest;
import org.ite.elearning.features.course.dto.CourseSnippetResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {

    void createCourse(CourseCreateRequest courseCreateRequest);

    Page<CourseSnippetResponse> findAllCourse(int page,int size);

}
