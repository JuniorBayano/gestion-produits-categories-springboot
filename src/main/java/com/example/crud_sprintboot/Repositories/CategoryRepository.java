package com.example.crud_sprintboot.Repositories;

import com.example.crud_sprintboot.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
    boolean existsByIdCategory(String idCategory);
    long count();
}