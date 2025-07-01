package com.example.crud_sprintboot.Request;

import java.time.LocalDate;

public record ProduitRequest(
        String nomProduit,
        Integer prixProduit,
        LocalDate dateExpiration,
        String categoryId
) {}