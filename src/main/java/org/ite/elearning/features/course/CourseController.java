package org.ite.elearning.features.course;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ite.elearning.features.course.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    public enum Response {
        COURSE_DETAIL,
        COURSE_SNIPPET
    }

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createCourse(@Valid @RequestBody CourseCreateRequest courseCreateRequest) {
        courseService.createCourse(courseCreateRequest);
    }

    @GetMapping("/all")
    Page<?> findAllCourse(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "COURSE_SNIPPET") Response response
    ) {
        return courseService.findAllCourse(page, size, response.name());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findCourseById(
            @PathVariable String id,
            @RequestParam(defaultValue = "COURSE_SNIPPET") Response response) {

        return courseService.findByCourseById(id, response.name());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCourseById(@PathVariable String id) {
        courseService.deleteCourseById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/visibility")
    void updateVisibility(@PathVariable String id, @RequestParam Boolean status) {
        courseService.updateVisibility(id, status);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/disable")
    void disableCourse(@PathVariable String id) {
        courseService.disableCourse(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/enable")
    void enableCourse(@PathVariable String id) {
        courseService.enableCourse(id);
    }

    // ====================Here====================

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/thumbnail")
    void updateThumbnail(@PathVariable String id, @Valid @RequestBody CourseUpdateThumbnail courseUpdateThumbnail) {
        courseService.updateThumbnail(id, courseUpdateThumbnail);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/isPaid")
    void updateIsPaid(@PathVariable String id, @RequestParam Boolean status) {
        courseService.updateIsPaid(id, status);
    }

    @GetMapping("/slug/{slug}")
    ResponseEntity<?> findCourseBySlug(@PathVariable String slug, @RequestParam(defaultValue = "COURSE_SNIPPET") Response response) {
        return courseService.findCourseBySlug(slug, response.name());
    }

    @GetMapping("/public")
    Page<?> findAllCoursePublic(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "COURSE_SNIPPET") Response response
    ) {
        return courseService.findAllCoursePublic(page, size, response.name());
    }

    @GetMapping("/private")
    Page<?> findAllCoursePrivate(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "COURSE_SNIPPET") Response response
    ) {
        return courseService.findAllCoursePrivate(page, size, response.name());
    }

    @GetMapping("/free")
    Page<?> findAllCourseIsFree(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "COURSE_SNIPPET") Response response
    ) {
        return courseService.findAllCourseIsFree(page, size, response.name());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateCourse(@PathVariable String id, @Valid @RequestBody CourseUpdateRequest courseUpdateRequest) {
        courseService.updateCourse(id, courseUpdateRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/sections")
    void createCourseSection(@PathVariable String id, @Valid @RequestBody SectionCreateRequest sectionCreateRequest) {
        courseService.createCourseSection(id, sectionCreateRequest);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{courseId}/videos")
    void createVideoInSection(@PathVariable String courseId, @Valid @RequestBody VideoCreateRequest videoCreateRequest) {
        courseService.createVideoInSection(courseId, videoCreateRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{courseId}/videos")
        void updateVideoInSection(@PathVariable String courseId, @Valid @RequestBody VideoUpdateRequest videoUpdateRequest) {
        courseService.updateVideoInSection(courseId, videoUpdateRequest);
    }

    @GetMapping("/instructor/{instructorName}")
    List<CourseDetailResponse> findAllCourseByInstructorName(@PathVariable String instructorName) {
        return courseService.findAllCourseByInstructorName(instructorName);
    }

    @GetMapping("/advancedSearch/params")
    Page<?> advancedSearchCourse(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String filterAnd,
            @RequestParam(required = false) String filterOr,
            @RequestParam(required = false) String orders,
            @RequestParam(defaultValue = "COURSE_SNIPPET") Response response
    ) {
        return courseService.advancedSearchCourseParam(page, size, filterAnd, filterOr, orders, response.name());
    }

    @PostMapping("/advancedSearch/body")
    Page<?> advancedSearchCourse(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @Valid @RequestBody FilterDTO filterDTO,
            @RequestParam(defaultValue = "COURSE_SNIPPET") Response response
    ) {
        return courseService.advancedSearchCourseRequestBody(page, size, filterDTO, response.name());
    }
}
