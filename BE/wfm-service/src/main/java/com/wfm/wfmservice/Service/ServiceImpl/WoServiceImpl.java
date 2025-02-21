package com.wfm.wfmservice.Service.ServiceImpl;

import com.example.common.Constant.Message;
import com.wfm.wfmservice.Convert.WfmConvertEntity;
import com.wfm.wfmservice.DTO.Wo.WoCUDto;
import com.wfm.wfmservice.DTO.Wo.WoDeleteDto;
import com.wfm.wfmservice.DTO.Wo.WoDetailDto;
import com.wfm.wfmservice.Repository.WoRepository;
import com.wfm.wfmservice.Service.WoService;
import com.wfm.wfmservice.Validate.WfmValidateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WoServiceImpl implements WoService {
    final WfmConvertEntity wfmConvertEntity;
    final WfmValidateEntity wfmValidateEntity;
    final WoRepository woRepository;

    @Autowired
    public WoServiceImpl(WfmConvertEntity wfmConvertEntity,
                         WfmValidateEntity wfmValidateEntity,
                         WoRepository woRepository) {
        this.wfmConvertEntity = wfmConvertEntity;
        this.wfmValidateEntity = wfmValidateEntity;
        this.woRepository = woRepository;
    }

    @Override
    public ResponseEntity<Object> getAllWo() {


        return ResponseEntity.status(HttpStatus.OK)
                .body(wfmConvertEntity.toWoDetailsDto(woRepository.getAllWo()));
    }

    @Override
    public ResponseEntity<Object> getWoById(Long id) {
        if (id == null || !woRepository.existsById(id))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_WO);
        WoDetailDto woDetailDto = wfmConvertEntity.toWoDetailDto(woRepository.getByWoId(id));

        return ResponseEntity.status(HttpStatus.OK).body(woDetailDto);
    }

    @Override
    public ResponseEntity<Object> createWo(WoCUDto woCUDto) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateWo(WoCUDto woCUDto) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteWo(List<WoDeleteDto> woDeleteDtos) {
        return null;
    }
}
