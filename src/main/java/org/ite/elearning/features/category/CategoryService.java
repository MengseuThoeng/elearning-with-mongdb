package org.ite.elearning.features.category;

import org.ite.elearning.domain.Category;
import org.ite.elearning.features.category.dto.CategoryCreateRequest;
import org.ite.elearning.features.category.dto.CategoryResponse;
import org.ite.elearning.features.category.dto.CategoryUpdateRequest;

import java.util.List;

public interface CategoryService {

    void createCategory(CategoryCreateRequest categoryCreateRequest);

    void  deleteCategory(String id);

    List<CategoryResponse> getAllCategories();

    void disableCategory(String id);

    void enableCategory(String id);

    CategoryResponse getCategoryById(String id);

    void updateCategory(String id, CategoryUpdateRequest categoryUpdateRequest);
}
