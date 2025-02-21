package com.common.commonservice.Service;

import com.common.commonservice.DTO.Category.CategoryCUDto;
import com.common.commonservice.DTO.Category.CategoryDeleteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<Object> getAllCategory();

    ResponseEntity<Object> createCategory(CategoryCUDto categoryCUDto);

    ResponseEntity<Object> updateCategory(CategoryCUDto categoryCUDto);

    ResponseEntity<Object> deleteCategory(List<CategoryDeleteDto> list);

    ResponseEntity<Object> getCategoryById(Long id);

    ResponseEntity<Object> getAllCategoryPaging(int first, int rows, int page, String categoryCode, String categoryName);
}
