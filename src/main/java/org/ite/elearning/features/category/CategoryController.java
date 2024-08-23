package org.ite.elearning.features.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ite.elearning.features.category.dto.CategoryCreateRequest;
import org.ite.elearning.features.category.dto.CategoryResponse;
import org.ite.elearning.features.category.dto.CategoryUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createCategory(@Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {
        categoryService.createCategory(categoryCreateRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping
    List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/disable")
    void disableCategory(@PathVariable String id) {
        categoryService.disableCategory(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/enable")
    void enableCategory(@PathVariable String id) {
        categoryService.enableCategory(id);
    }

    @GetMapping("/{id}")
    CategoryResponse getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateCategory(@PathVariable String id, @Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        categoryService.updateCategory(id, categoryUpdateRequest);
    }
}
