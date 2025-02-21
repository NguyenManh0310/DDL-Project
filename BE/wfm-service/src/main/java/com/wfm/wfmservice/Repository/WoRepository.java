package com.wfm.wfmservice.Repository;

import com.wfm.wfmservice.Entity.Wo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WoRepository extends JpaRepository<Wo, Long> {
    Wo getByWoId(Long id);

    @Query("select w from Wo w")
    List<Wo> getAllWo();


}
