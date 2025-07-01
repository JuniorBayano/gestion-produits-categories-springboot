package com.example.crud_sprintboot.Mapper;

import com.example.crud_sprintboot.Entities.Category;
import com.example.crud_sprintboot.Dto.CategoryDTO;
import com.example.crud_sprintboot.Request.CategoryRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {
    public Category toCategory(CategoryRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("La requete ne peut pas etre null");
        }

        return Category.builder()
                .idCategory(request.idCategory())
                .nomCategory(request.nomCategory())
                .produits(new ArrayList<>())
                .build();
    }

    public CategoryDTO toDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setIdCategory(category.getIdCategory());
        dto.setNomCategory(category.getNomCategory());
        return dto;
    }

    public List<String> validateCategoryRequest(CategoryRequest request) {
        List<String> errors = new ArrayList<>();

        if (request.idCategory() == null || request.idCategory().isEmpty()) {
            errors.add("L'ID de la categorie est requise");
        }

        if (request.nomCategory() == null || request.nomCategory().isEmpty()) {
            errors.add("Le nom de la categorie est requise");
        }

        return errors;
    }
}