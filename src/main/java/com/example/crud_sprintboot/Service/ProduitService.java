package com.example.crud_sprintboot.Service;

import com.example.crud_sprintboot.Entities.Category;
import com.example.crud_sprintboot.Entities.Produit;
import com.example.crud_sprintboot.Mapper.ProduitMapper;
import com.example.crud_sprintboot.Repositories.CategoryRepository;
import com.example.crud_sprintboot.Repositories.ProduitRepository;
import com.example.crud_sprintboot.Request.ProduitRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;
    private final CategoryRepository categoryRepository;
    private final ProduitMapper produitMapper;

    public ProduitService(ProduitRepository produitRepository,
                          CategoryRepository categoryRepository,
                          ProduitMapper mapper) {
        this.produitRepository = produitRepository;
        this.categoryRepository = categoryRepository;
        this.produitMapper = mapper;
    }

    public ResponseEntity<?> createProduit(ProduitRequest request) {
        List<String> errors = produitMapper.validateProduitRequest(request);
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Produit produit = produitMapper.toProduit(request);
        produitRepository.save(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(produitMapper.toDTO(produit));
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public ResponseEntity<?> getProduitById(UUID id) {
        return produitRepository.findById(id)
                .map(produit -> ResponseEntity.ok(produitMapper.toDTO(produit)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> updateProduit(UUID id, ProduitRequest request) {
        return produitRepository.findById(id)
                .map(existingProduit -> {
                    Category category = categoryRepository.findById(request.categoryId())
                            .orElseThrow(() -> new RuntimeException("Categorie non trouvee"));

                    existingProduit.setNomProduit(request.nomProduit());
                    existingProduit.setPrixProduit(request.prixProduit());
                    existingProduit.setDateExpiration(request.dateExpiration());
                    existingProduit.setCategory(category);

                    produitRepository.save(existingProduit);
                    return ResponseEntity.ok(produitMapper.toDTO(existingProduit));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteProduit(UUID id) {
        if (produitRepository.existsById(id)) {
            produitRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}