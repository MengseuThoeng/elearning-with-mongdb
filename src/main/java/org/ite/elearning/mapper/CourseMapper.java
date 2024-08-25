package org.ite.elearning.mapper;

import org.ite.elearning.domain.Course;
import org.ite.elearning.features.course.dto.CourseDetailResponse;
import org.ite.elearning.features.course.dto.CourseSnippetResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseSnippetResponse toCourseSnippetResponse(Course course);

    CourseDetailResponse toCourseDetailResponse(Course course);

}
