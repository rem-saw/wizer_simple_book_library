package com.wizer.wizer.controllers;

import com.wizer.wizer.dto.BookDto;
import com.wizer.wizer.dto.FavoriteDto;
import com.wizer.wizer.dto.GenRes;
import com.wizer.wizer.services.BookService;
import com.wizer.wizer.services.serviceImpl.BookServiceImpl1;
import com.wizer.wizer.services.serviceImpl.MapServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author samuel.sawyerr
 */


@Slf4j
@RestController
@RequestMapping("/wizer/book")
public class BookController {

    final private BookService bookService ;
    final private MapServiceImpl mapService ;

    public BookController(BookServiceImpl1 bookService,MapServiceImpl mapService) {
        this.bookService = bookService;
        this.mapService = mapService;
    }

    GenRes res ;
    @PostMapping("")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookDto req,BindingResult result) {
        res = new GenRes();
        ResponseEntity<?> errorMap = mapService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
       try {
           log.info("req::{}", req);
           BookDto book = bookService.addBook(req);
           res.setResponseCode("00");
           res.setResponseMesssage("Success");
           res.setData(book);
           return ResponseEntity.ok(res);
       } catch (Exception ex){
           res.setResponseCode("01");
           res.setResponseMesssage(ex.getMessage());
           return ResponseEntity.ok(res);
       }
    }

    @PostMapping("/{categoryId}/{isbn}")
    public ResponseEntity<?> addBookToCategory(@Valid @PathVariable String isbn,@Valid @PathVariable long categoryId)  {
        res = new GenRes();
        try {
            BookDto book = bookService.addBookToCategory(isbn, categoryId);
            res.setResponseCode("00");
            res.setResponseMesssage("Success");
            res.setData(book);
            return ResponseEntity.ok(res);
        } catch (Exception ex){
            res.setResponseCode("01");
            res.setResponseMesssage(ex.getMessage());
            return ResponseEntity.ok(res);
        }
    }

    @PutMapping("/{isbnNo}")
    public ResponseEntity<?> editBook(@Valid @RequestBody BookDto req,@Valid @PathVariable String isbnNo)  {
        res = new GenRes();
        try {
            BookDto bookDto = bookService.editBook(req, isbnNo);
            res.setResponseCode("00");
            res.setResponseMesssage("Success");
            res.setData(bookDto);
            return ResponseEntity.ok(res);
        } catch (Exception ex){
            res.setResponseCode("01");
            res.setResponseMesssage(ex.getMessage());
            return ResponseEntity.ok(res);
        }
    }

    @PostMapping("/favorite/{isbnNo}")
    public ResponseEntity<?> addToFavorite(@Valid @PathVariable String isbnNo)  {
        res = new GenRes();
        try {
            List<FavoriteDto> bookDto = bookService.addToFavorite(isbnNo);
            res.setResponseCode("00");
            res.setResponseMesssage("Success");
            res.setData(bookDto);
            return ResponseEntity.ok(res);
        } catch (Exception ex){
            res.setResponseCode("01");
            res.setResponseMesssage(ex.getMessage());
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getBooks()  {
        res = new GenRes();
        try {
            List<BookDto> bookDtos = bookService.getBooks();
            res.setResponseCode("00");
            res.setResponseMesssage("Success");
            res.setData(bookDtos);
            return ResponseEntity.ok(res);
        } catch (Exception ex){
            res.setResponseCode("01");
            res.setResponseMesssage(ex.getMessage());
            return ResponseEntity.ok(res);
        }
    }





}
