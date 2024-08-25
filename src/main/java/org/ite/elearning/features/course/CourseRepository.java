package org.ite.elearning.features.course;

import org.ite.elearning.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {

    Page<Course> findAllByIsDeletedIsFalseAndIsDraftIsFalse(PageRequest pageRequest);

}
