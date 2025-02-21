package com.common.commonservice.DTO.Category;

import com.common.commonservice.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryCUDto {
    private Long categoryId;
    private String categoryCode;
    private String categoryName;
    private Long status;

    public CategoryCUDto(Category category) {
        if (category != null) {
            this.categoryId = category.getCategoryId();
            this.categoryCode = category.getCategoryCode();
            this.categoryName = category.getCategoryName();
            this.status = category.getStatus();
        }
    }
}
