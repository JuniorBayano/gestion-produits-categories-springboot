package com.example.crud_sprintboot.Mapper;

import com.example.crud_sprintboot.Entities.Produit;
import com.example.crud_sprintboot.Dto.ProduitDTO;
import com.example.crud_sprintboot.Request.ProduitRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProduitMapper {
    public Produit toProduit(ProduitRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("La requete ne peut pas etre null");
        }

        Produit produit = new Produit();
        produit.setNomProduit(request.nomProduit());
        produit.setPrixProduit(request.prixProduit());
        produit.setDateExpiration(request.dateExpiration());
        return produit;
    }

    public ProduitDTO toDTO(Produit produit) {
        ProduitDTO dto = new ProduitDTO();
        dto.setIdProduit(produit.getIdProduit());
        dto.setNomProduit(produit.getNomProduit());
        dto.setPrixProduit(produit.getPrixProduit());
        dto.setDateExpiration(produit.getDateExpiration());
        if (produit.getCategory() != null) {
            dto.setCategoryId(produit.getCategory().getIdCategory());
        }
        return dto;
    }

    public List<String> validateProduitRequest(ProduitRequest request) {
        List<String> errors = new ArrayList<>();

        if (request.nomProduit() == null || request.nomProduit().isEmpty()) {
            errors.add("Le nom du produit est requis");
        }

        if (request.prixProduit() == null || request.prixProduit() <= 0) {
            errors.add("Le prix du produit doit etre positif");
        }

        if (request.categoryId() == null || request.categoryId().isEmpty()) {
            errors.add("La categorie du produit est requise");
        }

        return errors;
    }
}