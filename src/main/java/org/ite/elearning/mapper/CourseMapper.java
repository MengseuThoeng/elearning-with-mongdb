package org.ite.elearning.mapper;

import org.ite.elearning.domain.Course;
import org.ite.elearning.features.course.dto.CourseDetailResponse;
import org.ite.elearning.features.course.dto.CourseSnippetResponse;
import org.ite.elearning.features.course.dto.CourseUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseSnippetResponse toCourseSnippetResponse(Course course);

    CourseDetailResponse toCourseDetailResponse(Course course);

    // === new down ===

    // New method for updating an existing Course entity
    void updateCourseFromRequest(CourseUpdateRequest courseUpdateRequest, @MappingTarget Course course);

}
