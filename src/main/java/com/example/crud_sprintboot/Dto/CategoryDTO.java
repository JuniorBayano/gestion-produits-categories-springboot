package com.example.crud_sprintboot.Dto;

import java.util.List;

public class CategoryDTO {
    private String idCategory;
    private String nomCategory;
    private List<String> produitsIds; // Optionnel

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

    public List<String> getProduitsIds() {
        return produitsIds;
    }

    public void setProduitsIds(List<String> produitsIds) {
        this.produitsIds = produitsIds;
    }
}