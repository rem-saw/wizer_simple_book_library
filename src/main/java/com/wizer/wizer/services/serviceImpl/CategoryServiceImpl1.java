package com.wizer.wizer.services.serviceImpl;

import com.wizer.wizer.dto.CategoryDto;
import com.wizer.wizer.entities.Category;
import com.wizer.wizer.repositories.CategoryRepository;
import com.wizer.wizer.services.CategoryService;
import com.wizer.wizer.services.DtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author samuel.sawyerr
 */

@Service
public class CategoryServiceImpl1 implements CategoryService {

    final private CategoryRepository categoryRepository ;
    final private DtoService dtoService ;

    public CategoryServiceImpl1(final CategoryRepository categoryRepository, final DtoService dtoService) {
        this.categoryRepository = categoryRepository;
        this.dtoService = dtoService;
    }

    @Override
    public CategoryDto addCategory(CategoryDto req) {
        Category cat = dtoService.CategoryDtoToCategory(req) ;
        cat = categoryRepository.save(cat);
        CategoryDto categoryDto = dtoService.CategoryToCategoryDto(cat);
        return categoryDto ;
    }

    @Override
    public CategoryDto editCategory(CategoryDto req, long id) throws Exception {
        if (!categoryRepository.findById(id).isPresent()) throw new Exception("No Category with id: "+ id +" found") ;
        Category cat = dtoService.CategoryDtoToCategory(req) ;
        cat.setId(id);
        cat = categoryRepository.save(cat);
        CategoryDto categoryDto = dtoService.CategoryToCategoryDto(cat);
        return  categoryDto ;
    }

    @Override
    public void deleteCategory(long id) throws Exception {
        if (!categoryRepository.findById(id).isPresent()) throw new Exception("No Category with id: "+ id +" found") ;
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getCategories() throws Exception {
        final List<Category> categories = categoryRepository.findAll();
        if (categoryRepository.findAll() == null) throw new Exception("No Category found");
        final List<CategoryDto> categoryDtos = new ArrayList<>();
        categories.forEach(ct -> categoryDtos.add(dtoService.CategoryToCategoryDto(ct)));
        return categoryDtos;
    }
}
