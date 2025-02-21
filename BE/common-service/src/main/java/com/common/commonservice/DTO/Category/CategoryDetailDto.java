package com.common.commonservice.DTO.Category;

import com.common.commonservice.Entity.Category;
import com.example.common.BaseEntity.BaseEntityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDetailDto extends BaseEntityDto {
    private Long categoryId;
    private String categoryCode;
    private String categoryName;
    private Long status;

    public CategoryDetailDto(Category category) {
        if (category != null) {
            this.categoryId = category.getCategoryId();
            this.categoryCode = category.getCategoryCode();
            this.categoryName = category.getCategoryName();
            this.status = category.getStatus();
            super.setCreatedUser(category.getCreatedUser());
            super.setUpdatedUser(category.getUpdatedUser());
            super.setCreatedTime(category.getCreatedTime());
            super.setUpdatedTime(category.getUpdatedTime());
        }
    }

}
