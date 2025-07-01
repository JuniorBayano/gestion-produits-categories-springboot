package com.example.crud_sprintboot.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "id_category", unique = true)
    private String idCategory;

    @Column(nullable = false)
    private String nomCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Produit> produits;

    public Category() {}

    public Category(String idCategory, String nomCategory, List<Produit> produits) {
        this.idCategory = idCategory;
        this.nomCategory = nomCategory;
        this.produits = produits;
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNomCategory() {
        return nomCategory;
    }

    public void setNomCategory(String nomCategory) {
        this.nomCategory = nomCategory;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public static class CategoryBuilder {
        private String idCategory;
        private String nomCategory;
        private List<Produit> produits;

        public CategoryBuilder idCategory(String idCategory) {
            this.idCategory = idCategory;
            return this;
        }

        public CategoryBuilder nomCategory(String nomCategory) {
            this.nomCategory = nomCategory;
            return this;
        }

        public CategoryBuilder produits(List<Produit> produits) {
            this.produits = produits;
            return this;
        }

        public Category build() {
            return new Category(idCategory, nomCategory, produits);
        }
    }
}