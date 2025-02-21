package com.wfm.wfmservice.Validate;

import com.common.commonservice.Repository.ItemRepository;
import com.common.commonservice.Repository.UserRepository;
import com.wfm.wfmservice.DTO.Wo.WoCUDto;
import com.wfm.wfmservice.DTO.WoConfigBusiness.WoConfigBusinessCUDto;
import com.wfm.wfmservice.DTO.WoType.WoTypeCUDto;
import com.wfm.wfmservice.Entity.WoConfigBusiness;
import com.wfm.wfmservice.Repository.WoConfigBusinessRepository;
import com.wfm.wfmservice.Repository.WoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.example.common.Constant.Message;
import com.example.common.Constant.Condition;

import java.util.Objects;

@Component
public class WfmValidateEntity {
    private final WoTypeRepository woTypeRepository;
    private final WoConfigBusinessRepository woConfigBusinessRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Autowired
    public WfmValidateEntity(WoTypeRepository woTypeRepository,
                             WoConfigBusinessRepository woConfigBusinessRepository,
                             ItemRepository itemRepository,
                             UserRepository userRepository) {
        this.woTypeRepository = woTypeRepository;
        this.woConfigBusinessRepository = woConfigBusinessRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;

    }

    public ResponseEntity<Object> validateWoType(WoTypeCUDto woTypeCUDto, String option) {
        if (option.equals("create") || option.equals("update")) {
            if (woTypeCUDto == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_DATA);

            if (woTypeCUDto.getWoTypeCode() == null || woTypeCUDto.getWoTypeCode().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_WO_TYPE_CODE);

            if (woTypeCUDto.getWoTypeName() == null || woTypeCUDto.getWoTypeName().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_WO_TYPE_NAME);

            if (woTypeCUDto.getStatus() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_STATUS);

            if (woTypeCUDto.getStatus() != 0L && woTypeCUDto.getStatus() != 1L)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_STATUS);

            if (!woTypeCUDto.getProcessTime().toString().matches(Condition.REGEX_PROCESS_TIME))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_PROCESS_TIME);

            if (woTypeCUDto.getWoTypeName().length() > Condition.MAX_LENGTH_WO_TYPE_NAME)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_WO_TYPE_NAME);

            if (woTypeCUDto.getWoTypeCode().length() > Condition.MAX_LENGTH_WO_TYPE_CODE)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_WO_TYPE_CODE);

            if (option.equals("create")) {
                if (woTypeRepository.existsByWoTypeCode(woTypeCUDto.getWoTypeCode()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_WO_TYPE_CODE);
            }

            if (option.equals("update")) {
                if (woTypeCUDto.getWoTypeId() == null
                        || woTypeRepository.getByWoTypeId(woTypeCUDto.getWoTypeId()) == null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_WO_TYPE);

                if (woTypeRepository.existsByWoTypeCode(woTypeCUDto.getWoTypeCode()) &&
                        !woTypeRepository.
                                getByWoTypeCode(woTypeCUDto.getWoTypeCode()).getWoTypeId().
                                equals(woTypeCUDto.getWoTypeId()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_WO_TYPE_CODE);

            }

        }

        return ResponseEntity.status(HttpStatus.OK).body(Message.VALID_DATA);
    }

    public ResponseEntity<Object> validateWoConfigBusiness(WoConfigBusinessCUDto woConfigBusinessCUDto, String option) {
        if (option.equals("create") || option.equals("update")) {
            if (woConfigBusinessCUDto == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_DATA);

            if (woConfigBusinessCUDto.getWoTypeId() == null || !woTypeRepository.existsById(woConfigBusinessCUDto.getWoTypeId()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_WO_TYPE);

            if (woConfigBusinessCUDto.getPriorityId() == null || !itemRepository.existsById(woConfigBusinessCUDto.getPriorityId()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_PRIORITY);

            if (woConfigBusinessCUDto.getOldStatus() == null || !itemRepository.existsById(woConfigBusinessCUDto.getOldStatus()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_OLD_STATUS);

            if (woConfigBusinessCUDto.getNewStatus() == null || !itemRepository.existsById(woConfigBusinessCUDto.getNewStatus()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_NEW_STATUS);

            if (option.equals("create")) {
                if (woConfigBusinessRepository.existsByWoTypeIdAndPriorityIdAndOldStatusAndNewStatus
                        (woConfigBusinessCUDto.getWoTypeId(), woConfigBusinessCUDto.getPriorityId(),
                                woConfigBusinessCUDto.getOldStatus(), woConfigBusinessCUDto.getNewStatus()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_WO_CONFIG_BUSINESS);

            }

            if (option.equals("update")) {
                if (woConfigBusinessCUDto.getConfigBusinessId() == null
                        || woConfigBusinessRepository.getByConfigBusinessId
                        (woConfigBusinessCUDto.getConfigBusinessId()) == null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_WO_CONFIG_BUSINESS);
                WoConfigBusiness woConfigBusiness =
                        woConfigBusinessRepository.getByWoTypeIdAndPriorityIdAndOldStatusAndNewStatus
                                (woConfigBusinessCUDto.getWoTypeId(), woConfigBusinessCUDto.getPriorityId(),
                                        woConfigBusinessCUDto.getOldStatus(), woConfigBusinessCUDto.getNewStatus());
                if (!Objects.equals(woConfigBusiness.getConfigBusinessId(), woConfigBusinessCUDto.getConfigBusinessId()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_WO_CONFIG_BUSINESS);
            }

        }
        return ResponseEntity.status(HttpStatus.OK).body(Message.VALID_DATA);
    }

    public ResponseEntity<Object> validateWo(WoCUDto woCUDto, String option) {
        if (option.equals("create") || option.equals("update")) {
            if (woCUDto == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_DATA);

            if (woCUDto.getWoContent() == null || woCUDto.getWoContent().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_WO_CONTENT);

            if (woCUDto.getWoTypeId() == null || !woTypeRepository.existsById(woCUDto.getWoTypeId()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_WO_TYPE);

            if (woCUDto.getPriorityId() == null || !itemRepository.existsById(woCUDto.getPriorityId()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_PRIORITY);

            if (woCUDto.getStatus() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_STATUS);

            if (woCUDto.getStartTime() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_START_TIME);

            if (woCUDto.getAssignUserId() == null || !userRepository.existsById(woCUDto.getAssignUserId()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_USER);

            //Cùng phòng ban người đc chọn //
            //Thời gian bắt đầu phải > hiện tại?


            if (option.equals("create")) {
                if (woCUDto.getStatus() != 1L)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_STATUS);
            }

            if (option.equals("update")) {

            }

        }
        return ResponseEntity.status(HttpStatus.OK).body(Message.VALID_DATA);
    }
}
