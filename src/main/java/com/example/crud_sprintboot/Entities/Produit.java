package com.example.crud_sprintboot.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Entity
@Table(name = "produits")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produit {
    @Id
    @GeneratedValue
    @Column(name = "id_produit")
    private UUID idProduit;

    @Column(nullable = false)
    private String nomProduit;

    @Column(nullable = false)
    private Integer prixProduit;

    private LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}