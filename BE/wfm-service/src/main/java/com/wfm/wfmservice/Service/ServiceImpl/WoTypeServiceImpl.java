package com.wfm.wfmservice.Service.ServiceImpl;

import com.example.common.Constant.Message;
import com.wfm.wfmservice.Convert.WfmConvertEntity;
import com.wfm.wfmservice.DTO.WoType.WoTypeCUDto;
import com.wfm.wfmservice.DTO.WoType.WoTypeDeleteDto;
import com.wfm.wfmservice.DTO.WoType.WoTypeDetailDto;
import com.wfm.wfmservice.Entity.WoType;
import com.wfm.wfmservice.Repository.WoTypeRepository;
import com.wfm.wfmservice.Service.WoTypeService;
import com.wfm.wfmservice.Validate.WfmValidateEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class WoTypeServiceImpl implements WoTypeService {
    final WfmConvertEntity wfmConvertEntity;
    final WfmValidateEntity wfmValidateEntity;
    final WoTypeRepository woTypeRepository;

    public WoTypeServiceImpl(WfmConvertEntity wfmConvertEntity,
                             WfmValidateEntity wfmValidateEntity,
                             WoTypeRepository woTypeRepository) {
        this.wfmConvertEntity = wfmConvertEntity;
        this.wfmValidateEntity = wfmValidateEntity;
        this.woTypeRepository = woTypeRepository;
    }

    @Override
    public ResponseEntity<Object> getAllWoType() {
        List<WoType> list = woTypeRepository.getAllWoType();
        return ResponseEntity.status(HttpStatus.OK)
                .body(wfmConvertEntity.toWoTypeDetailsDto(list));
    }

    @Override
    public ResponseEntity<Object> createWoType(WoTypeCUDto woTypeCUDto) {
        if (!Objects.requireNonNull(wfmValidateEntity.validateWoType(woTypeCUDto, "create").
                getBody()).toString().equals(Message.VALID_DATA))
            return wfmValidateEntity.validateWoType(woTypeCUDto, "create");
        WoType woType = new WoType(woTypeCUDto);
        woType.setCreatedUser(1L);
        woType.setCreatedTime(Date.valueOf(LocalDate.now()));
        woType.setStatus(1L);
        woTypeRepository.save(woType);
        return ResponseEntity.status(HttpStatus.OK).body(woTypeCUDto);
    }

    @Override
    public ResponseEntity<Object> updateWoType(WoTypeCUDto woTypeCUDto) {
        if (!Objects.requireNonNull(wfmValidateEntity.validateWoType(woTypeCUDto, "update").
                getBody()).toString().equals(Message.VALID_DATA))
            return wfmValidateEntity.validateWoType(woTypeCUDto, "update");
        WoType woType = woTypeRepository.getByWoTypeId(woTypeCUDto.getWoTypeId());
        woType.setStatus(woType.getStatus());
        woType.setWoTypeCode(woTypeCUDto.getWoTypeCode());
        woType.setWoTypeName(woTypeCUDto.getWoTypeName());
        woType.setProcessTime(woTypeCUDto.getProcessTime());
        woType.setUpdatedUser(1L);
        woType.setUpdatedTime(Date.valueOf(LocalDate.now()));
        woTypeRepository.save(woType);
        return ResponseEntity.status(HttpStatus.OK).body(woTypeCUDto);
    }

    @Override
    public ResponseEntity<Object> getWoTypeById(Long id) {
        if (id == null || woTypeRepository.getByWoTypeId(id) == null)
            return ResponseEntity.status(HttpStatus.OK).body(Message.NOT_EXIST_WO_TYPE);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new WoTypeDetailDto(woTypeRepository.getByWoTypeId(id)));
    }

    @Override
    public ResponseEntity<Object> deleteWoType(List<WoTypeDeleteDto> list) {
        return null;
    }
}
