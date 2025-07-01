package com.example.crud_sprintboot.Service;

import com.example.crud_sprintboot.Entities.Category;
import com.example.crud_sprintboot.Mapper.CategoryMapper;
import com.example.crud_sprintboot.Repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.crud_sprintboot.Request.CategoryRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    // Constructeur avec injection de dépendances
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<?> createCategory(CategoryRequest request) {
        List<String> errors = mapper.validateCategoryRequest(request);
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Category category = mapper.toCategory(request);
        categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(category));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public ResponseEntity<?> getCategoryById(String id) {
        return categoryRepository.findById(id)
                .map(category -> ResponseEntity.ok(mapper.toDTO(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> updateCategory(String id, CategoryRequest request) {
        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    existingCategory.setNomCategory(request.nomCategory());
                    categoryRepository.save(existingCategory);
                    return ResponseEntity.ok(mapper.toDTO(existingCategory));  // Utilisez mapper
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteCategory(String id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}