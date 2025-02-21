package com.common.commonservice.DTO.Item;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPagingDto {
    private Long totalRecords;
    private List<ItemDetailDto> data;
}
