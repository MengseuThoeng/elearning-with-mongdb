package org.ite.elearning.features.course;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ite.elearning.features.course.dto.CourseCreateRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
