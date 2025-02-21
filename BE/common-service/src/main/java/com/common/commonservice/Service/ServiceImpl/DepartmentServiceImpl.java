package com.common.commonservice.Service.ServiceImpl;

import com.common.commonservice.DTO.Department.DepartmentPagingDto;
import com.example.common.Constant.Message;
import com.common.commonservice.Convert.CommonConvertEntity;
import com.common.commonservice.DTO.Department.DepartmentDeleteDto;
import com.common.commonservice.DTO.Department.DepartmentDetailDTO;
import com.common.commonservice.DTO.Department.DepartmentCUDto;
import com.common.commonservice.Entity.Department;
import com.common.commonservice.Repository.DepartmentRepository;
import com.common.commonservice.Repository.UserRepository;
import com.common.commonservice.Service.DepartmentService;
import com.common.commonservice.Validate.CommonValidateEntity;
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
public class DepartmentServiceImpl implements DepartmentService {
    final UserRepository userRepository;
    final CommonConvertEntity commonConvertEntity;
    final CommonValidateEntity commonValidateEntity;
    final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(UserRepository userRepository,
                                 CommonConvertEntity commonConvertEntity,
                                 CommonValidateEntity commonValidateEntity,
                                 DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.commonConvertEntity = commonConvertEntity;
        this.commonValidateEntity = commonValidateEntity;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ResponseEntity<Object> getAllDepartment() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonConvertEntity.toDepartmentDetailsDto(departmentRepository.getAllDepartment()));
    }

    @Override
    public ResponseEntity<Object> getDepartmentById(Long id) {
        if (id == null || departmentRepository.getByDepartmentId(id) == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_DEPARTMENT);

        return ResponseEntity.status(HttpStatus.OK).
                body(new DepartmentDetailDTO(departmentRepository.getByDepartmentId(id)));
    }

    @Override
    public ResponseEntity<Object> createDepartment(DepartmentCUDto departmentCUDto) {
        if (!Objects.requireNonNull(commonValidateEntity.validateDepartment(departmentCUDto, "create").
                getBody()).toString().equals(Message.VALID_DATA))
            return commonValidateEntity.validateDepartment(departmentCUDto, "create");

        Department department = new Department(departmentCUDto);
        department.setStatus(departmentCUDto.getStatus());
        department.setCreatedUser(1L);
        department.setCreatedTime(Date.valueOf(LocalDate.now()));

        if (departmentCUDto.getParentDepartmentId() != null)
            department.setParentDepartmentId(departmentCUDto.getParentDepartmentId());

        departmentRepository.save(department);

        return ResponseEntity.status(HttpStatus.OK).body(departmentCUDto);
    }

    @Override
    public ResponseEntity<Object> updateDepartment(DepartmentCUDto departmentCUDto) {
        if (!Objects.requireNonNull(commonValidateEntity.validateDepartment(departmentCUDto, "update").
                getBody()).toString().equals(Message.VALID_DATA))
            return commonValidateEntity.validateDepartment(departmentCUDto, "update");

        Department department = departmentRepository.getByDepartmentId(departmentCUDto.getDepartmentId());

        department.setDepartmentCode(departmentCUDto.getDepartmentCode());
        department.setDepartmentName(departmentCUDto.getDepartmentName());
        department.setStatus(departmentCUDto.getStatus());
        department.setUpdatedUser(1L);
        department.setUpdatedTime(Date.valueOf(LocalDate.now()));

        departmentRepository.save(department);
        return ResponseEntity.status(HttpStatus.OK).body(departmentCUDto);
    }

    @Override
    public ResponseEntity<Object> deleteDepartment(List<DepartmentDeleteDto> departmentDeleteDtos) {
        List<Department> departments = new ArrayList<>();
        for (DepartmentDeleteDto departmentDeleteDto : departmentDeleteDtos
        ) {
            if (departmentDeleteDto.getDepartmentId() == null
                    || departmentRepository.getByDepartmentId(departmentDeleteDto.getDepartmentId()) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(Message.NOT_EXIST_DEPARTMENT + " " + Message.DEPARTMENT_DELETED);

            Department department = departmentRepository.getByDepartmentId(departmentDeleteDto.getDepartmentId());
            departments.add(department);
        }
        departmentRepository.deleteAll(departments);
        return ResponseEntity.status(HttpStatus.OK).body(departmentDeleteDtos);
    }

    @Override
    public ResponseEntity<Object> getAllParentDepartment() {
        return null;
    }

    @Override
    public ResponseEntity<Object> getAllDepartmentPaging(int first, int rows, int page, String departmentCode, String departmentName) {
        Pageable pageable = PageRequest.of(page, rows);
        Page<Department> departments = departmentRepository.getAllDepartmentPaging(departmentCode, departmentName, pageable);
        if (departments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
        DepartmentPagingDto departmentPagingDto = new DepartmentPagingDto(departments.getTotalElements(),
                commonConvertEntity.toDepartmentDetailsDto(departments.getContent()));
        return ResponseEntity.status(HttpStatus.OK).body(departmentPagingDto);
    }
}
