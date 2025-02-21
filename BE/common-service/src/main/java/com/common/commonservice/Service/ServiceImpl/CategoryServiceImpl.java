package com.common.commonservice.Service.ServiceImpl;

import com.common.commonservice.DTO.Category.CategoryPagingDto;
import com.common.commonservice.DTO.Department.DepartmentDeleteDto;
import com.common.commonservice.DTO.Department.DepartmentPagingDto;
import com.common.commonservice.Entity.Department;
import com.example.common.Constant.Message;
import com.common.commonservice.Convert.CommonConvertEntity;
import com.common.commonservice.DTO.Category.CategoryCUDto;
import com.common.commonservice.DTO.Category.CategoryDeleteDto;
import com.common.commonservice.DTO.Category.CategoryDetailDto;
import com.common.commonservice.Entity.Category;
import com.common.commonservice.Repository.CategoryRepository;
import com.common.commonservice.Service.CategoryService;
import com.common.commonservice.Validate.CommonValidateEntity;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {
    final CommonConvertEntity commonConvertEntity;
    final CommonValidateEntity commonValidateEntity;
    final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CommonConvertEntity commonConvertEntity,
                               CommonValidateEntity commonValidateEntity,
                               CategoryRepository categoryRepository) {
        this.commonConvertEntity = commonConvertEntity;
        this.commonValidateEntity = commonValidateEntity;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<Object> getAllCategory() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonConvertEntity.toCategoryDetailDto(categoryRepository.getAllCategory()));
    }

    @Override
    public ResponseEntity<Object> createCategory(CategoryCUDto categoryCUDto) {
        if (!Objects.requireNonNull(commonValidateEntity.validateCategory(categoryCUDto, "create").
                getBody()).toString().equals(Message.VALID_DATA))
            return commonValidateEntity.validateCategory(categoryCUDto, "create");

        Category category = new Category(categoryCUDto);

        category.setCreatedUser(1L);
        category.setCreatedTime(Date.valueOf(LocalDate.now()));
        category.setStatus(categoryCUDto.getStatus());
        categoryRepository.save(category);

        return ResponseEntity.status(HttpStatus.OK).body(categoryCUDto);
    }

    @Override
    public ResponseEntity<Object> updateCategory(CategoryCUDto categoryCUDto) {
        if (!Objects.requireNonNull(commonValidateEntity.validateCategory(categoryCUDto, "update").
                getBody()).toString().equals(Message.VALID_DATA))
            return commonValidateEntity.validateCategory(categoryCUDto, "update");

        Category category = categoryRepository.getByCategoryId(categoryCUDto.getCategoryId());
        category.setCategoryCode(categoryCUDto.getCategoryCode());
        category.setCategoryName(categoryCUDto.getCategoryName());
        category.setUpdatedTime(Date.valueOf(LocalDate.now()));
        category.setUpdatedUser(1L);
        category.setStatus(categoryCUDto.getStatus());
        categoryRepository.save(category);

        return ResponseEntity.status(HttpStatus.OK).body(categoryCUDto);
    }

    @Override
    public ResponseEntity<Object> deleteCategory(List<CategoryDeleteDto> categoryDeleteDtos) {
        List<Category> categories = new ArrayList<>();
        for (CategoryDeleteDto categoryDeleteDto : categoryDeleteDtos
        ) {
            if (categoryDeleteDto.getCategoryId() == null
                    || categoryRepository.getByCategoryId(categoryDeleteDto.getCategoryId()) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(Message.NOT_EXIST_CATEGORY + " " + Message.CATEGORY_DELETED);

            Category category = categoryRepository.getByCategoryId(categoryDeleteDto.getCategoryId());
            categories.add(category);
        }
        categoryRepository.deleteAll(categories);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDeleteDtos);
    }

    @Override
    public ResponseEntity<Object> getCategoryById(Long id) {
        if (id == null || !categoryRepository.existsByCategoryId(id))
            return ResponseEntity.status(HttpStatus.OK).body(Message.NOT_EXIST_CATEGORY);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new CategoryDetailDto(categoryRepository.getByCategoryId(id)));
    }

    @Override
    public ResponseEntity<Object> getAllCategoryPaging(int first, int rows, int page, String categoryCode, String categoryName) {
        Pageable pageable = PageRequest.of(page, rows);
        Page<Category> categories = categoryRepository.getAllCategoryPaging(categoryCode, categoryName, pageable);
        if (categories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
        CategoryPagingDto categoryPagingDto = new CategoryPagingDto(categories.getTotalElements(),
                commonConvertEntity.toCategoryDetailDto(categories.getContent()));
        return ResponseEntity.status(HttpStatus.OK).body(categoryPagingDto);
    }
}
