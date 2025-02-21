package com.common.commonservice.DTO.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPagingDto {
    private Long totalRecords;
    private List<CategoryDetailDto> data;
}
