package com.common.commonservice.DTO.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPagingDto {
    private Long totalRecords;
    private List<UserDetailDto> data;
}
