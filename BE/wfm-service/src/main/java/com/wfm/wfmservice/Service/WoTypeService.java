package com.wfm.wfmservice.Service;

import com.wfm.wfmservice.DTO.WoType.WoTypeCUDto;
import com.wfm.wfmservice.DTO.WoType.WoTypeDeleteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WoTypeService {
    ResponseEntity<Object> getAllWoType();
    ResponseEntity<Object> createWoType(WoTypeCUDto woTypeCUDto);
    ResponseEntity<Object> updateWoType(WoTypeCUDto woTypeCUDto);
    ResponseEntity<Object> getWoTypeById(Long id);
    ResponseEntity<Object> deleteWoType(List<WoTypeDeleteDto> list);
}
