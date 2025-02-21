package com.common.commonservice.Controller;

import com.common.commonservice.DTO.Category.CategoryCUDto;
import com.common.commonservice.DTO.Category.CategoryDeleteDto;
import com.common.commonservice.DTO.Department.DepartmentDeleteDto;
import com.common.commonservice.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/common/category")
public class CategoryController {
    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/get-category")
    public ResponseEntity<Object> getCategoryById(@RequestParam Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/create-category")
    public ResponseEntity<Object> createCategory(@RequestBody CategoryCUDto categoryCUDto) {
        return categoryService.createCategory(categoryCUDto);
    }

    @PutMapping("/update-category")
    public ResponseEntity<Object> updateCategory(@RequestBody CategoryCUDto categoryCUDto) {
        return categoryService.updateCategory(categoryCUDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCategory(@RequestBody List<CategoryDeleteDto> categoryDeleteDtos) {
        return categoryService.deleteCategory(categoryDeleteDtos);
    }

    @GetMapping("/paging")
    public ResponseEntity<Object> getCategoryPaging(
            @RequestParam(defaultValue = "0") int first,
            @RequestParam(defaultValue = "10") int rows,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String categoryCode,
            @RequestParam(required = false) String categoryName) {
        return categoryService.getAllCategoryPaging(first, rows, page, categoryCode, categoryName);
    }
}
