package com.wizer.wizer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author samuel.sawyerr
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {

    @NotBlank(message = "authorNo is required")
    @NotNull(message="authorNo cannot be null")
    private String authorNo ;

    @NotBlank(message = "isbnNo is required")
    @NotNull(message="isbnNo cannot be null")
    private String isbnNo ;

    @NotBlank(message = "title is required")
    @NotNull(message="title cannot be null")
    private  String title ;
    private String edition;

    @NotNull(message="price cannot be null")
    private Double price;

    public String getAuthorNo() {
        return authorNo;
    }

    public void setAuthorNo(String authorNo) {
        this.authorNo = authorNo;
    }

    public String getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(String isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
