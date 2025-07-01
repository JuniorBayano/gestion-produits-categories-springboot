package com.example.crud_sprintboot.Repositories;

import com.example.crud_sprintboot.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {
    long count();
}