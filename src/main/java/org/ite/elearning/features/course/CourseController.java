package org.ite.elearning.features.course;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ite.elearning.features.course.dto.CourseCreateRequest;
import org.ite.elearning.features.course.dto.CourseSnippetResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createCourse(@Valid @RequestBody CourseCreateRequest courseCreateRequest) {
        courseService.createCourse(courseCreateRequest);
    }

    @GetMapping("/all")
    Page<CourseSnippetResponse> findAllCourse(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return courseService.findAllCourse(page, size);
    }
}
