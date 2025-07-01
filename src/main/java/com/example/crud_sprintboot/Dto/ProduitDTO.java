package com.example.crud_sprintboot.Dto;

import java.time.LocalDate;
import java.util.UUID;

public class ProduitDTO {
    private UUID idProduit;
    private String nomProduit;
    private Integer prixProduit;
    private LocalDate dateExpiration;
    private String categoryId;

    // Constructeur par défaut
    public ProduitDTO() {}

    // Getters
    public UUID getIdProduit() { return idProduit; }
    public String getNomProduit() { return nomProduit; }
    public Integer getPrixProduit() { return prixProduit; }
    public LocalDate getDateExpiration() { return dateExpiration; }
    public String getCategoryId() { return categoryId; }

    // Setters
    public void setIdProduit(UUID idProduit) { this.idProduit = idProduit; }
    public void setNomProduit(String nomProduit) { this.nomProduit = nomProduit; }
    public void setPrixProduit(Integer prixProduit) { this.prixProduit = prixProduit; }
    public void setDateExpiration(LocalDate dateExpiration) { this.dateExpiration = dateExpiration; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
}