package com.wizer.wizer.services.serviceImpl;

import com.wizer.wizer.dto.BookDto;
import com.wizer.wizer.dto.CategoryDto;
import com.wizer.wizer.dto.FavoriteDto;
import com.wizer.wizer.entities.Book;
import com.wizer.wizer.entities.Category;
import com.wizer.wizer.entities.Favorite;
import com.wizer.wizer.services.DtoService;
import org.springframework.stereotype.Service;

/**
 * @author samuel.sawyerr
 */

@Service
public class DtoServiceImpl1 implements DtoService {

    public Book BookDtoToBook(BookDto req){
        Book book = new Book();
        book.setAuthorNo(req.getAuthorNo());
        book.setEdition(req.getEdition());
        book.setPrice(req.getPrice());
        book.setTitle(req.getTitle());
        book.setIsbnNo(req.getIsbnNo());
        return book;
    }

    public BookDto BookToBookDto(Book req){
        BookDto bookDto = new BookDto();
        bookDto.setAuthorNo(req.getAuthorNo());
        bookDto.setEdition(req.getEdition());
        bookDto.setPrice(req.getPrice());
        bookDto.setTitle(req.getTitle());
        bookDto.setIsbnNo(req.getIsbnNo());
        return bookDto;
    }



    public Category CategoryDtoToCategory(CategoryDto req){
        Category cat = new Category();
        cat.setCategoryName(req.getCategoryName());
        return cat;
    }

    public CategoryDto CategoryToCategoryDto(Category req){
        CategoryDto catDto = new CategoryDto();
        catDto.setCategoryName(req.getCategoryName());
        catDto.setId(req.getId());
        return catDto;
    }

    public FavoriteDto FavoriteToFavoriteDto(Favorite req){
        FavoriteDto favoriteDto = new FavoriteDto();
        favoriteDto.setBookAuthor(req.getBook().getAuthorNo());
        favoriteDto.setBookIsbnNo(req.getBook().getIsbnNo());
        favoriteDto.setBookTitle(req.getBook().getTitle());
        return favoriteDto;
    }


}
