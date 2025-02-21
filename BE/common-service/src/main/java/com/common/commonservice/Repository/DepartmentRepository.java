package com.common.commonservice.Repository;

import com.common.commonservice.DTO.Department.DepartmentDetailDTO;
import com.common.commonservice.DTO.User.UserDetailDto;
import com.common.commonservice.Entity.Department;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department getByDepartmentId(Long departmentId);

    @Query("select Department from Department d")
    List<Department> getAllDepartment();

    @Query("select Department from Department d where d.parentDepartmentId=101")
    List<Department> getAllParentDepartment();

    Department getByDepartmentCode(String code);

    @Query("SELECT d FROM Department d " +
            "WHERE (:departmentCode IS NULL OR LOWER(d.departmentCode) LIKE LOWER(CONCAT('%', :departmentCode, '%')) OR :departmentCode = '') " +
            "AND (:departmentName IS NULL OR LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :departmentName, '%')) OR :departmentName = '') ")
    Page<Department> getAllDepartmentPaging(@Param("departmentCode") String departmentCode,
                                            @Param("departmentName") String departmentName,
                                            Pageable pageable);

}
