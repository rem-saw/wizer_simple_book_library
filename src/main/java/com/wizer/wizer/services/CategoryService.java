package com.wizer.wizer.services;

import com.wizer.wizer.dto.CategoryDto;

import java.util.List;

/**
 * @author samuel.sawyerr
 */
public interface CategoryService {
    CategoryDto addCategory(CategoryDto req);
    CategoryDto editCategory(CategoryDto req, long id) throws Exception;
    List<CategoryDto> getCategories() throws Exception;
    void deleteCategory(long id) throws Exception;;
}
