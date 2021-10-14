package com.wizer.wizer.services;

import com.wizer.wizer.dto.BookDto;
import com.wizer.wizer.dto.CategoryDto;
import com.wizer.wizer.dto.FavoriteDto;
import com.wizer.wizer.entities.Book;
import com.wizer.wizer.entities.Category;
import com.wizer.wizer.entities.Favorite;

/**
 * @author samuel.sawyerr
 */
public interface DtoService {

    Book BookDtoToBook(BookDto req);
    BookDto BookToBookDto(Book req);
    Category CategoryDtoToCategory(CategoryDto req);
    CategoryDto CategoryToCategoryDto(Category req);
    FavoriteDto FavoriteToFavoriteDto(Favorite req);

}
