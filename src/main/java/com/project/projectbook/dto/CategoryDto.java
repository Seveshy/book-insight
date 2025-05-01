package com.project.projectbook.dto;

import com.project.projectbook.entities.Category;

public class CategoryDto {

    private Long id;
    private String category;

    public CategoryDto() {
    }

    public CategoryDto(Category categoryEntities) {
        this.id = categoryEntities.getId();
        this.category = categoryEntities.getCategory();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
   

}
