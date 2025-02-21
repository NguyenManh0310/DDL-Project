package com.common.commonservice.Repository;

import com.common.commonservice.Entity.Category;
import com.common.commonservice.Entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getByCategoryId(Long id);

    @Query("select Category from Category d")
    List<Category> getAllCategory();

    boolean existsByCategoryCode(String code);

    boolean existsByCategoryId(Long id);

    Category getByCategoryCode(String code);

    @Query("SELECT c FROM Category c " +
            "WHERE (:categoryCode IS NULL OR LOWER(c.categoryCode) LIKE LOWER(CONCAT('%', :categoryCode, '%')) OR :categoryCode = '') " +
            "AND (:categoryName IS NULL OR LOWER(c.categoryName) LIKE LOWER(CONCAT('%', :categoryName, '%')) OR :categoryName = '') ")
    Page<Category> getAllCategoryPaging(@Param("categoryCode") String categoryCode,
                                        @Param("categoryName") String categoryName,
                                        Pageable pageable);
}
