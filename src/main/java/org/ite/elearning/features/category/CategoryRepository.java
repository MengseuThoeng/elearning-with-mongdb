package org.ite.elearning.features.category;

import org.ite.elearning.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Boolean existsByName(String name);

    @Query("{ 'isDeleted' : false }")
    List<Category> findAllINotDeleted();

    Optional<Category> findByIdAndIsDeletedIsFalse(String id);
}
