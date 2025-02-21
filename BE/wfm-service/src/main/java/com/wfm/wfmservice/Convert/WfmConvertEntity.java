package com.wfm.wfmservice.Convert;

import com.common.commonservice.Entity.User;
import com.common.commonservice.Repository.ItemRepository;
import com.common.commonservice.Repository.UserRepository;
import com.wfm.wfmservice.DTO.Wo.WoDetailDto;
import com.wfm.wfmservice.DTO.WoConfigBusiness.WoConfigBusinessDetailDto;
import com.wfm.wfmservice.DTO.WoType.WoTypeDetailDto;
import com.wfm.wfmservice.Entity.Wo;
import com.wfm.wfmservice.Entity.WoConfigBusiness;
import com.wfm.wfmservice.Entity.WoType;
import com.wfm.wfmservice.Repository.WoTypeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WfmConvertEntity {
    final ItemRepository itemRepository;
    final WoTypeRepository woTypeRepository;
    final UserRepository userRepository;

    public WfmConvertEntity(ItemRepository itemRepository,
                            WoTypeRepository woTypeRepository,
                            UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.woTypeRepository = woTypeRepository;
        this.userRepository = userRepository;
    }

    public List<WoTypeDetailDto> toWoTypeDetailsDto(List<WoType> woTypes) {
        List<WoTypeDetailDto> list = new ArrayList<>();
        for (WoType woType : woTypes
        ) {

            list.add(new WoTypeDetailDto(woType));
        }
        return list;
    }

    public List<WoDetailDto> toWoDetailsDto(List<Wo> wos) {
        List<WoDetailDto> list = new ArrayList<>();
        for (Wo wo : wos
        ) {
            list.add(toWoDetailDto(wo));
        }
        return list;
    }

    public WoDetailDto toWoDetailDto(Wo wo) {
        WoDetailDto woDetailDto = new WoDetailDto(wo);
        if (!woTypeRepository.existsById(wo.getWoTypeId())) {
            woDetailDto.setWoTypeName(woTypeRepository.getByWoTypeId(wo.getWoTypeId()).getWoTypeName());
        }
        if (!itemRepository.existsById(wo.getPriorityId())) {
            woDetailDto.setPriorityName(itemRepository.getByItemId(wo.getPriorityId()).getItemName());
        }

        User user = userRepository.getUserByUserId(wo.getAssignUserId());
        woDetailDto.setAssignUserFullName(user.getFirstName() + " " + user.getLastName());
        return woDetailDto;
    }

    public WoConfigBusinessDetailDto toWoConfigBusinessDetailDto(WoConfigBusiness woConfigBusiness) {

        WoConfigBusinessDetailDto woConfigBusinessDetailDto = new WoConfigBusinessDetailDto(woConfigBusiness);
        if (!itemRepository.existsById(woConfigBusiness.getPriorityId())) {
            woConfigBusinessDetailDto.
                    setPriorityName(itemRepository.getByItemId(woConfigBusiness.getPriorityId()).getItemName());
        }
        if (!woTypeRepository.existsById(woConfigBusiness.getWoTypeId())) {
            woConfigBusinessDetailDto.
                    setWoTypeName(woTypeRepository.getByWoTypeId(woConfigBusiness.getWoTypeId()).getWoTypeName());
        }
        if (!itemRepository.existsById(woConfigBusiness.getOldStatus())) {
            woConfigBusinessDetailDto.
                    setOldStatus(itemRepository.getByItemId(woConfigBusiness.getOldStatus()).getItemName());
        }
        if (!itemRepository.existsById(woConfigBusiness.getNewStatus())) {
            woConfigBusinessDetailDto.
                    setNewStatus(itemRepository.getByItemId(woConfigBusiness.getNewStatus()).getItemName());
        }


        return woConfigBusinessDetailDto;
    }

    public List<WoConfigBusinessDetailDto> toWoConfigBusinessDetailsDto(List<WoConfigBusiness> woConfigBusinesses) {
        List<WoConfigBusinessDetailDto> list = new ArrayList<>();
        for (WoConfigBusiness woConfigBusiness : woConfigBusinesses
        ) {
            list.add(toWoConfigBusinessDetailDto(woConfigBusiness));
        }
        return list;
    }
}
