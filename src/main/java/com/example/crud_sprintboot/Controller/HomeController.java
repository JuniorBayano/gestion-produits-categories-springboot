package com.example.crud_sprintboot.Controller;

import com.example.crud_sprintboot.Service.CategoryService;
import com.example.crud_sprintboot.Service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CategoryService categoryService;
    private final ProduitService produitService;

    public HomeController(CategoryService categoryService, ProduitService produitService) {
        this.categoryService = categoryService;
        this.produitService = produitService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categoriesCount", categoryService.getAllCategories().size());
        model.addAttribute("productsCount", produitService.getAllProduits().size());
        return "home";
    }
}