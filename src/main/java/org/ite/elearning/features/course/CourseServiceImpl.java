package org.ite.elearning.features.course;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ite.elearning.domain.Category;
import org.ite.elearning.domain.Course;
import org.ite.elearning.features.category.CategoryRepository;
import org.ite.elearning.features.course.dto.CourseCreateRequest;
import org.ite.elearning.features.course.dto.CourseSnippetResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    private final CategoryRepository categoryRepository;

    @Override
    public Page<CourseSnippetResponse> findAllCourse(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return courseRepository.findAll(pageable)
                .map(course -> new CourseSnippetResponse(
                        course.getId(),
                        course.getTitle(),
                        course.getSlug(),
                        course.getDescription(),
                        course.getThumbnail(),
                        course.getPrice(),
                        course.getDiscount(),
                        course.getCode(),
                        course.getIsPaid(),
                        course.getIsDraft(),
                        course.getInstructorName(),
                        course.getCategoryName(),
                        course.getCreatedAt(),
                        course.getUpdatedAt()
                ));

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
