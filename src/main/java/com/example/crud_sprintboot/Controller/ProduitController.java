package com.example.crud_sprintboot.Controller;

import com.example.crud_sprintboot.Entities.Category;
import com.example.crud_sprintboot.Entities.Produit;
import com.example.crud_sprintboot.Request.ProduitRequest;
import com.example.crud_sprintboot.Service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/produits")
public class ProduitController {
    private final ProduitService produitService;



    @GetMapping
    public String showProductsPage(Model model) {
        model.addAttribute("products", produitService.getAllProduits());
        return "products";
    }

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public ResponseEntity<?> createProduit(@RequestBody ProduitRequest request) {
        return produitService.createProduit(request);
    }

//    @GetMapping
//    public List<Produit> getAllProduits() {
//        return produitService.getAllProduits();
//    }

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

//    @GetMapping("/products")
//    public String products(Model model) {
//        return "products";
//    }
}