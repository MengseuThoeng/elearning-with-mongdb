package org.ite.elearning.features.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ite.elearning.domain.Category;
import org.ite.elearning.features.category.dto.CategoryCreateRequest;
import org.ite.elearning.features.category.dto.CategoryResponse;
import org.ite.elearning.features.category.dto.CategoryUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public CategoryResponse getCategoryById(String id) {
        Category category = categoryRepository.findByIdAndIsDeletedIsFalse(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id " + id + " not found"
                ));
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getIcon()
        );
    }

    @Override
    public void updateCategory(String id, CategoryUpdateRequest categoryUpdateRequest) {
        Category category = categoryRepository.findByIdAndIsDeletedIsFalse(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id " + id + " not found"
                ));

        if (categoryRepository.existsByName(categoryUpdateRequest.name())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category with name " + categoryUpdateRequest.name() + " already exists"
            );
        }

        category.setName(categoryUpdateRequest.name());

        categoryRepository.save(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAllINotDeleted();
        return categories.stream()
                .map(category -> new CategoryResponse(
                                category.getId(),
                                category.getName(),
                                category.getIcon()
                        )
                ).toList();
    }

    @Override
    public void disableCategory(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id " + id + " not found"
                ));
        category.setIsDeleted(true);
        categoryRepository.save(category);
    }

    @Override
    public void enableCategory(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id " + id + " not found"
                ));
        category.setIsDeleted(false);
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Category with id " + id + " not found"
            );
        }

        categoryRepository.deleteById(id);
    }

    @Override
    public void createCategory(CategoryCreateRequest categoryCreateRequest) {

        if (categoryRepository.existsByName(categoryCreateRequest.name())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category with name " + categoryCreateRequest.name() + " already exists"
            );
        }

        Category category = new Category();
        category.setName(categoryCreateRequest.name());
        category.setIcon(categoryCreateRequest.icon());
        category.setIsDeleted(false);

        categoryRepository.save(category);
    }
}
