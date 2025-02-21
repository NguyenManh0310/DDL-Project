package com.wfm.wfmservice.Repository;

import com.wfm.wfmservice.Entity.WoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WoTypeRepository extends JpaRepository<WoType, Long> {
    WoType getByWoTypeId(Long id);

    @Query("select wt from WoType wt ")
    List<WoType> getAllWoType();

    boolean existsByWoTypeCode(String code);

    WoType getByWoTypeCode(String code);
}
