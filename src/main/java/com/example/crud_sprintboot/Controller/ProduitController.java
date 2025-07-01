package com.example.crud_sprintboot.Controller;

import com.example.crud_sprintboot.Entities.Produit;
import com.example.crud_sprintboot.Request.ProduitRequest;
import com.example.crud_sprintboot.Service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public ResponseEntity<?> createProduit(@RequestBody ProduitRequest request) {
        return produitService.createProduit(request);
    }

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduitById(@PathVariable UUID id) {
        return produitService.getProduitById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduit(
            @PathVariable UUID id,
            @RequestBody ProduitRequest request) {
        return produitService.updateProduit(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable UUID id) {
        return produitService.deleteProduit(id);
    }
}