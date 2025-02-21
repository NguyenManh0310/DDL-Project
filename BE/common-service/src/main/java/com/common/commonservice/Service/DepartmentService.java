package com.common.commonservice.Service;

import com.common.commonservice.DTO.Department.DepartmentCUDto;
import com.common.commonservice.DTO.Department.DepartmentDeleteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    ResponseEntity<Object> getAllDepartment();
    ResponseEntity<Object> getDepartmentById(Long id);
    ResponseEntity<Object> createDepartment(DepartmentCUDto departmentCUDto);
    ResponseEntity<Object> updateDepartment(DepartmentCUDto departmentCUDto);
    ResponseEntity<Object> deleteDepartment(List<DepartmentDeleteDto> departmentDeleteDtos);
    ResponseEntity<Object> getAllParentDepartment();
    ResponseEntity<Object> getAllDepartmentPaging(int first, int rows, int page,String departmentCode,String departmentName);
}
