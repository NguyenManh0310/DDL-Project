package com.wfm.wfmservice.Service;

import com.wfm.wfmservice.DTO.Wo.WoCUDto;
import com.wfm.wfmservice.DTO.Wo.WoDeleteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WoService {
    ResponseEntity<Object> getAllWo();
    ResponseEntity<Object> getWoById(Long id);
    ResponseEntity<Object> createWo(WoCUDto woCUDto);
    ResponseEntity<Object> updateWo(WoCUDto woCUDto);
    ResponseEntity<Object> deleteWo(List<WoDeleteDto> woDeleteDtos);


}
