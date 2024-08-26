package org.ite.elearning.features.course;

import org.ite.elearning.features.course.dto.*;
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

    // here

    void updateThumbnail(String id, CourseUpdateThumbnail courseUpdateThumbnail);

    void updateIsPaid(String id, Boolean isPaid);

    ResponseEntity<?> findCourseBySlug(String slug, String response);

    Page<?> findAllCoursePublic(int page, int size, String response);

    Page<?> findAllCoursePrivate(int page, int size, String response);

    Page<?> findAllCourseIsFree(int page, int size, String response);

    void updateCourse(String id, CourseUpdateRequest courseUpdateRequest);

    void createCourseSection(String id, SectionCreateRequest sectionCreateRequest);

    void createVideoInSection(String courseId, VideoCreateRequest videoCreateRequest);

    void updateVideoInSection(String courseId, VideoUpdateRequest videoUpdateRequest);

    List<CourseDetailResponse> findAllCourseByInstructorName(String instructorName);

    Page<?> advancedSearchCourseParam(int page, int size, String filterAnd, String filterOr, String orders, String response);

    Page<?> advancedSearchCourseRequestBody(int page, int size, FilterDTO filterDTO, String response);

}
