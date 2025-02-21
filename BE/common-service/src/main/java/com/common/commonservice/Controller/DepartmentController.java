package com.common.commonservice.Controller;

import com.common.commonservice.DTO.Department.DepartmentCUDto;
import com.common.commonservice.DTO.Department.DepartmentDeleteDto;
import com.common.commonservice.Service.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/common/department")
@Tag(name = "department Controller", description = "APIs for department Controller")
public class DepartmentController {
    final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/get-department")
    public ResponseEntity<Object> getDepartmentById(@RequestParam Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/create-department")
    public ResponseEntity<Object> createDepartment(@RequestBody DepartmentCUDto departmentCUDto) {
        return departmentService.createDepartment(departmentCUDto);
    }

    @PutMapping("/update-department")
    public ResponseEntity<Object> updateDepartment(@RequestBody DepartmentCUDto departmentCUDto) {
        return departmentService.updateDepartment(departmentCUDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteDepartment(@RequestBody List<DepartmentDeleteDto> departmentCUDtos) {
        return departmentService.deleteDepartment(departmentCUDtos);
    }
    @GetMapping("/paging")
    public ResponseEntity<Object> getDepartmentPaging(
            @RequestParam(defaultValue = "0") int first,
            @RequestParam(defaultValue = "10") int rows,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String departmentCode,
            @RequestParam(required = false) String departmentName) {
        return departmentService.getAllDepartmentPaging(first, rows, page, departmentCode, departmentName);
    }
}
