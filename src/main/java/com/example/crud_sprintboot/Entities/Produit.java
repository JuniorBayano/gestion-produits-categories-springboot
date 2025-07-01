package com.example.crud_sprintboot.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "produits")
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

    public Produit() {}

    public Produit(UUID idProduit, String nomProduit, Integer prixProduit,
                   LocalDate dateExpiration, Category category) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateExpiration = dateExpiration;
        this.category = category;
    }

    public static ProduitBuilder builder() {
        return new ProduitBuilder();
    }

    public UUID getIdProduit() { return idProduit; }
    public String getNomProduit() { return nomProduit; }
    public Integer getPrixProduit() { return prixProduit; }
    public LocalDate getDateExpiration() { return dateExpiration; }
    public Category getCategory() { return category; }

    public void setIdProduit(UUID idProduit) { this.idProduit = idProduit; }
    public void setNomProduit(String nomProduit) { this.nomProduit = nomProduit; }
    public void setPrixProduit(Integer prixProduit) { this.prixProduit = prixProduit; }
    public void setDateExpiration(LocalDate dateExpiration) { this.dateExpiration = dateExpiration; }
    public void setCategory(Category category) { this.category = category; }

    public static class ProduitBuilder {
        private UUID idProduit;
        private String nomProduit;
        private Integer prixProduit;
        private LocalDate dateExpiration;
        private Category category;

        public ProduitBuilder idProduit(UUID idProduit) {
            this.idProduit = idProduit;
            return this;
        }

        public ProduitBuilder nomProduit(String nomProduit) {
            this.nomProduit = nomProduit;
            return this;
        }

        public ProduitBuilder prixProduit(Integer prixProduit) {
            this.prixProduit = prixProduit;
            return this;
        }

        public ProduitBuilder dateExpiration(LocalDate dateExpiration) {
            this.dateExpiration = dateExpiration;
            return this;
        }

        public ProduitBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public Produit build() {
            return new Produit(idProduit, nomProduit, prixProduit, dateExpiration, category);
        }
    }
}