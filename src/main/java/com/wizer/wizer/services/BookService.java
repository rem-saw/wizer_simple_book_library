package com.wizer.wizer.services;

import com.wizer.wizer.dto.BookDto;
import com.wizer.wizer.dto.FavoriteDto;

import java.util.List;

/**
 * @author samuel.sawyerr
 */
public interface BookService {

    BookDto addBook(BookDto req) throws Exception;
    BookDto editBook(BookDto req, String isbnNo) throws Exception;
    List<FavoriteDto> addToFavorite(String isbnNo) throws Exception;
    List<BookDto> getBooks() throws Exception;
    BookDto addBookToCategory(String isbn, long categoryId) throws Exception;

}
