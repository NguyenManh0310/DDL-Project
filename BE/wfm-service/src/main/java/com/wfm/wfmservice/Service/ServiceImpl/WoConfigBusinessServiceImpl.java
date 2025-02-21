package com.wfm.wfmservice.Service.ServiceImpl;

import com.example.common.Constant.Message;
import com.wfm.wfmservice.Convert.WfmConvertEntity;
import com.wfm.wfmservice.DTO.WoConfigBusiness.WoConfigBusinessCUDto;
import com.wfm.wfmservice.DTO.WoConfigBusiness.WoConfigBusinessDeleteDto;
import com.wfm.wfmservice.Entity.WoConfigBusiness;
import com.wfm.wfmservice.Repository.WoConfigBusinessRepository;
import com.wfm.wfmservice.Service.WoConfigBusinessService;
import com.wfm.wfmservice.Validate.WfmValidateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class WoConfigBusinessServiceImpl implements WoConfigBusinessService {
    final WfmConvertEntity wfmConvertEntity;
    final WfmValidateEntity wfmValidateEntity;
    final WoConfigBusinessRepository woConfigBusinessRepository;

    @Autowired
    public WoConfigBusinessServiceImpl(WfmConvertEntity wfmConvertEntity,
                                       WfmValidateEntity wfmValidateEntity,
                                       WoConfigBusinessRepository woConfigBusinessRepository) {
        this.wfmConvertEntity = wfmConvertEntity;
        this.wfmValidateEntity = wfmValidateEntity;
        this.woConfigBusinessRepository = woConfigBusinessRepository;

    }

    @Override
    public ResponseEntity<Object> getAllWoConfigBusiness() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(wfmConvertEntity.toWoConfigBusinessDetailsDto(woConfigBusinessRepository.getAllWoConfigBusiness()));
    }

    @Override
    public ResponseEntity<Object> createWoConfigBusiness(WoConfigBusinessCUDto woConfigBusinessCUDto) {
        if (!Objects.requireNonNull(wfmValidateEntity.validateWoConfigBusiness(woConfigBusinessCUDto, "create").
                getBody()).toString().equals(Message.VALID_DATA))
            return wfmValidateEntity.validateWoConfigBusiness(woConfigBusinessCUDto, "create");
        WoConfigBusiness woConfigBusiness = new WoConfigBusiness();
        woConfigBusiness.setConfigBusinessId(woConfigBusinessCUDto.getConfigBusinessId());
        woConfigBusiness.setPriorityId(woConfigBusinessCUDto.getPriorityId());
        woConfigBusiness.setOldStatus(woConfigBusinessCUDto.getOldStatus());
        woConfigBusiness.setNewStatus(woConfigBusinessCUDto.getNewStatus());
        woConfigBusiness.setCreatedTime(Date.valueOf(LocalDate.now()));
        woConfigBusiness.setCreatedUser(1L);
        woConfigBusinessRepository.save(woConfigBusiness);
        return ResponseEntity.status(HttpStatus.OK).body(woConfigBusinessCUDto);
    }

    @Override
    public ResponseEntity<Object> updateWoConfigBusiness(WoConfigBusinessCUDto woConfigBusinessCUDto) {
        if (!Objects.requireNonNull(wfmValidateEntity.validateWoConfigBusiness(woConfigBusinessCUDto, "update").
                getBody()).toString().equals(Message.VALID_DATA))
            return wfmValidateEntity.validateWoConfigBusiness(woConfigBusinessCUDto, "update");
        WoConfigBusiness woConfigBusiness =
                woConfigBusinessRepository.getByConfigBusinessId(woConfigBusinessCUDto.getConfigBusinessId());
        woConfigBusiness.setConfigBusinessId(woConfigBusinessCUDto.getConfigBusinessId());
        woConfigBusiness.setPriorityId(woConfigBusinessCUDto.getPriorityId());
        woConfigBusiness.setOldStatus(woConfigBusinessCUDto.getOldStatus());
        woConfigBusiness.setNewStatus(woConfigBusinessCUDto.getNewStatus());
        woConfigBusiness.setUpdatedTime(Date.valueOf(LocalDate.now()));
        woConfigBusiness.setCreatedUser(1L);
        woConfigBusinessRepository.save(woConfigBusiness);
        return ResponseEntity.status(HttpStatus.OK).body(woConfigBusinessCUDto);
    }

    @Override
    public ResponseEntity<Object> deleteWoConfigBusiness(List<WoConfigBusinessDeleteDto> woConfigBusinessDeleteDtos) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getWoConfigBusinessById(Long id) {
        if (id == null || !woConfigBusinessRepository.existsById(id))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_WO_CONFIG_BUSINESS);
        return ResponseEntity.status(HttpStatus.OK).body(woConfigBusinessRepository.getByConfigBusinessId(id));
    }
}
