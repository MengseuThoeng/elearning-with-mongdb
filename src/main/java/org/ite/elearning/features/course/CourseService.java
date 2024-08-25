package org.ite.elearning.features.course;

import org.ite.elearning.features.course.dto.CourseCreateRequest;
import org.ite.elearning.features.course.dto.CourseSnippetResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    void createCourse(CourseCreateRequest courseCreateRequest);

    Page<?> findAllCourse(int page,int size, String response);

    ResponseEntity<?> findByCourseById(String id, String response);

    void deleteCourseById (String id);

    void updateVisibility(String id, Boolean visibility);

    void disableCourse(String id);

    void enableCourse(String id);

}
