package com.wfm.wfmservice.Service;

import com.wfm.wfmservice.DTO.WoConfigBusiness.WoConfigBusinessCUDto;
import com.wfm.wfmservice.DTO.WoConfigBusiness.WoConfigBusinessDeleteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WoConfigBusinessService {
    ResponseEntity<Object> getAllWoConfigBusiness();
    ResponseEntity<Object> createWoConfigBusiness(WoConfigBusinessCUDto woConfigBusinessCUDto);
    ResponseEntity<Object> updateWoConfigBusiness(WoConfigBusinessCUDto woConfigBusinessCUDto);
    ResponseEntity<Object> deleteWoConfigBusiness(List<WoConfigBusinessDeleteDto> woConfigBusinessDeleteDtos);
    ResponseEntity<Object> getWoConfigBusinessById(Long id);
}
