package com.common.commonservice.DTO.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentPagingDto {
    private Long totalRecords;
    private List<DepartmentDetailDTO> data;
}
