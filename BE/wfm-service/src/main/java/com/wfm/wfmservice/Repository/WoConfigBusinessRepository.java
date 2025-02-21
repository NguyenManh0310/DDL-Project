package com.wfm.wfmservice.Repository;

import com.wfm.wfmservice.Entity.WoConfigBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WoConfigBusinessRepository extends JpaRepository<WoConfigBusiness, Long> {
    WoConfigBusiness getByConfigBusinessId(Long id);

    @Query("select w from WoConfigBusiness w")
    List<WoConfigBusiness> getAllWoConfigBusiness();

    Boolean existsByWoTypeIdAndPriorityIdAndOldStatusAndNewStatus(Long woTypeId, Long priorityId, Long oldStatus, Long newStatus);
    WoConfigBusiness getByWoTypeIdAndPriorityIdAndOldStatusAndNewStatus(Long woTypeId, Long priorityId, Long oldStatus, Long newStatus);
}
