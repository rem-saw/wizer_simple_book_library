package com.wizer.wizer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author samuel.sawyerr
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FavoriteDto {
    private String bookTitle;
    private String bookAuthor ;
    private String bookIsbnNo ;


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookIsbnNo() {
        return bookIsbnNo;
    }

    public void setBookIsbnNo(String bookIsbnNo) {
        this.bookIsbnNo = bookIsbnNo;
    }
}
