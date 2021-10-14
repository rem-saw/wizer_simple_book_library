package com.wizer.wizer.services.serviceImpl;

import com.wizer.wizer.dto.BookDto;
import com.wizer.wizer.dto.FavoriteDto;
import com.wizer.wizer.entities.Book;
import com.wizer.wizer.entities.Category;
import com.wizer.wizer.entities.Favorite;
import com.wizer.wizer.repositories.BookRepository;
import com.wizer.wizer.repositories.CategoryRepository;
import com.wizer.wizer.repositories.FavoriteRepository;
import com.wizer.wizer.services.BookService;
import com.wizer.wizer.services.DtoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author samuel.sawyerr
 */

@Slf4j
@Service
public class BookServiceImpl1 implements BookService {

    final private BookRepository bookRepository ;
    final private DtoService dtoService;
    final private CategoryRepository categoryRepository;
    final private FavoriteRepository favoriteRepository;

    public BookServiceImpl1(BookRepository bookRepository, CategoryRepository categoryRepository, DtoServiceImpl1 dtoServiceImpl1,
                            FavoriteRepository favoriteRepository){
        this.bookRepository = bookRepository;
        this.dtoService = dtoServiceImpl1;
        this.categoryRepository = categoryRepository ;
        this.favoriteRepository = favoriteRepository;

    }


    @Override
    final public BookDto addBook(BookDto req) throws Exception {
        if (bookRepository.existsByIsbnNo(req.getIsbnNo())) {
            throw new Exception("Isbn Number : " + req.getIsbnNo() + " already registered/exists.");
        }
        Book book = dtoService.BookDtoToBook(req) ;
        log.info("req::{}",book);
        book = bookRepository.save(book);
        BookDto bookDto = dtoService.BookToBookDto(book);
        return  bookDto ;
    }

    @Override
    final public BookDto editBook(BookDto req,String id) throws Exception {
        if (!bookRepository.findByIsbnNo(id).isPresent()) throw new Exception("No Book with isbnNo: "+ id +" found") ;
        req.setIsbnNo(id);
        Book book = dtoService.BookDtoToBook(req) ;
        book.setId(bookRepository.findByIsbnNo(id).get().getId());
        book = bookRepository.save(book);
        BookDto bookDto = dtoService.BookToBookDto(book);
        return bookDto;
    }

    @Override
    final public List<FavoriteDto> addToFavorite(String isbnNo) throws Exception {
        if (!bookRepository.findByIsbnNo(isbnNo).isPresent()) throw new Exception("No Book with isbnNo: "+ isbnNo +" found") ;
        Book book = bookRepository.findByIsbnNo(isbnNo).get();
        Favorite favorite = new Favorite();
        favorite.setBook(book);
        favoriteRepository.save(favorite);
        List<Favorite> favorites = favoriteRepository.findAll();
        List<FavoriteDto> res = new ArrayList<>();
        favorites.forEach(f-> res.add(dtoService.FavoriteToFavoriteDto(f)));
        return res ;
    }


    @Override
    final public List<BookDto> getBooks() throws Exception {
        final List<Book> books = bookRepository.findAll();
        if (bookRepository.findAll() == null) throw new Exception("No Book found");
        final List<BookDto> bookDtos = new ArrayList<>();
        books.forEach(bk -> bookDtos.add(dtoService.BookToBookDto(bk)));
        return bookDtos;
    }

    @Override
    final public BookDto addBookToCategory(final String isbn, final long categoryId) throws Exception {
        if (!bookRepository.findByIsbnNo(isbn).isPresent())throw new Exception("No Book found with isbn: "+isbn);
        Book book = bookRepository.findByIsbnNo(isbn).get();
        if (!categoryRepository.findById(categoryId).isPresent()) throw new Exception("Category with id: "+categoryId+" is found.");
        final Category cat = categoryRepository.findById(categoryId).get();
        book.setCategory(cat);
        book = bookRepository.save(book);
        BookDto bookDto = dtoService.BookToBookDto(book);
        return  bookDto;
    }
}
