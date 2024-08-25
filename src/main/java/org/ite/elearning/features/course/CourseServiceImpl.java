package org.ite.elearning.features.course;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ite.elearning.domain.Course;
import org.ite.elearning.features.category.CategoryRepository;
import org.ite.elearning.features.course.dto.CourseCreateRequest;
import org.ite.elearning.features.course.dto.CourseDetailResponse;
import org.ite.elearning.features.course.dto.CourseSnippetResponse;
import org.ite.elearning.mapper.CourseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    private final CategoryRepository categoryRepository;


    @Override
    public void disableCourse(String id) {
        Course course = courseRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found..!"
                )
        );
        course.setIsDeleted(true);
        courseRepository.save(course);
    }

    @Override
    public void enableCourse(String id) {
        Course course = courseRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found..!"
                )
        );
        course.setIsDeleted(false);
        courseRepository.save(course);
    }

    @Override
    public void updateVisibility(String id, Boolean visibility) {
        Course course = courseRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found..!"
                )
        );
        course.setIsDraft(visibility);
        courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(String id) {
        Course course = courseRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found..!"
                )
        );
        courseRepository.delete(course);
    }

    @Override
    public ResponseEntity<?> findByCourseById(String id, String response) {

        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found..!"
                )
        );

        if (response.equals("COURSE_DETAIL")) {
            CourseDetailResponse detailResponse = courseMapper.toCourseDetailResponse(course);
            return new ResponseEntity<>(detailResponse,HttpStatus.OK);
        }

        CourseSnippetResponse snippetResponse = courseMapper.toCourseSnippetResponse(course);
        return new ResponseEntity<>(snippetResponse,HttpStatus.OK);
    }

    @Override
    public Page<?> findAllCourse(int page, int size, String response) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Course> findAllCourses = courseRepository.findAllByIsDeletedIsFalseAndIsDraftIsFalse(pageRequest);

        if (response.equals("COURSE_DETAIL")) {
            return findAllCourses.map(courseMapper::toCourseDetailResponse);
        }

        return findAllCourses.map(courseMapper::toCourseSnippetResponse);
    }


    @Override
    public void createCourse(CourseCreateRequest courseCreateRequest) {

        if (!categoryRepository.existsByNameAndIsDeletedIsFalse(courseCreateRequest.categoryName())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Category not found..!"
            );
        }

        Course course = new Course();


        course.setTitle(courseCreateRequest.title());
        course.setSlug(courseCreateRequest.slug());
        course.setDescription(courseCreateRequest.description());
        course.setThumbnail(courseCreateRequest.thumbnail());
        course.setPrice(courseCreateRequest.price());
        course.setContent(courseCreateRequest.content());
        course.setCategoryName(courseCreateRequest.categoryName());
        course.setIsDeleted(false);
        course.setIsDraft(true);
        course.setIsPaid(false);
        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(LocalDateTime.now());
        course.setInstructorName("Thoeng_Mengseu");
        course.setSections(List.of());
        course.setCode(UUID.randomUUID().toString().substring(0, 5));

        courseRepository.save(course);
    }
}
