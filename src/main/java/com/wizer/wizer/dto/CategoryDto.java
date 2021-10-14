package com.wizer.wizer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author samuel.sawyerr
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {


    @NotBlank(message = "CategoryName is required")
    @NotNull(message="CategoryName cannot be null")
    private String categoryName ;

    private long id ;








    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
