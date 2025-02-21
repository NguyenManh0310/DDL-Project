package com.common.commonservice.DTO.User;

import com.common.commonservice.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.common.BaseEntity.BaseEntityDto;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDto extends BaseEntityDto {
    private Long userId;
    private String userName;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String departmentName;
    private Long status;

    public UserDetailDto(User user) {
        if (user != null) {
            this.userId = user.getUserId();
            this.email = user.getEmail();
            this.phoneNumber = user.getPhoneNumber();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            if (user.getDepartment() != null) {
                this.departmentName = user.getDepartment().getDepartmentName();
            }
            this.userName=user.getUserName();
            this.status = user.getStatus();
            super.setCreatedUser(user.getCreatedUser());
            super.setUpdatedUser(user.getUpdatedUser());
            super.setCreatedTime(user.getCreatedTime());
            super.setUpdatedTime(user.getUpdatedTime());
        }


    }
}
