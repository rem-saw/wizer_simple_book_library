package com.wizer.wizer.controllers;

import com.wizer.wizer.dto.BookDto;
import com.wizer.wizer.dto.CategoryDto;
import com.wizer.wizer.dto.GenRes;
import com.wizer.wizer.entities.Category;
import com.wizer.wizer.services.CategoryService;
import com.wizer.wizer.services.serviceImpl.CategoryServiceImpl1;
import com.wizer.wizer.services.serviceImpl.MapServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author samuel.sawyerr
 */

@RestController
@RequestMapping("/wizer/category")
@Api(value = "Category Resource REST Endpoint",description = "")
public class CategoryController {

    final private CategoryService categoryService ;
    final private MapServiceImpl mapService;

    public CategoryController(final CategoryServiceImpl1 categoryService,MapServiceImpl mapService) {
        this.categoryService = categoryService;
        this.mapService = mapService;
    }

    GenRes res ;

    @PostMapping("")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDto req, BindingResult result)  {
        res = new GenRes();
       try {
           ResponseEntity<?> errorMap = mapService.MapValidationService(result);
           if (errorMap != null) return errorMap;
           CategoryDto category = categoryService.addCategory(req);
           res.setResponseCode("00");
           res.setResponseMesssage("Success");
           res.setData(category);
           return ResponseEntity.ok(res);
       } catch (Exception ex){
           res.setResponseCode("01");
           res.setResponseMesssage(ex.getMessage());
           return ResponseEntity.ok(res);
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editBook(@Valid @RequestBody CategoryDto req,@Valid @PathVariable long id)  {
        res = new GenRes();
       try {
           CategoryDto category = categoryService.editCategory(req, id);
           res.setResponseCode("00");
           res.setResponseMesssage("Success");
           res.setData(category);
           return ResponseEntity.ok(res);
       } catch (Exception ex){
           res.setResponseCode("01");
           res.setResponseMesssage(ex.getMessage());
           return ResponseEntity.ok(res);
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@Valid @PathVariable long id)  {
        res = new GenRes();
        try {
            categoryService.deleteCategory(id);
            res.setResponseCode("00");
            res.setResponseMesssage("Deleted");
            return ResponseEntity.ok(res);
        } catch (Exception ex){
            res.setResponseCode("01");
            res.setResponseMesssage(ex.getMessage());
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getCategories()  {
        res = new GenRes();
        try {
            List<CategoryDto> categoryDto = categoryService.getCategories();
            res.setResponseCode("00");
            res.setResponseMesssage("Success");
            res.setData(categoryDto);
            return ResponseEntity.ok(res);
        } catch (Exception ex){
            res.setResponseCode("01");
            res.setResponseMesssage(ex.getMessage());
            return ResponseEntity.ok(res);
        }
    }

}
