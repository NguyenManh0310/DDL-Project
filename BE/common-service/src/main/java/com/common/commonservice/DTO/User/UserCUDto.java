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
public class UserCUDto {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Long departmentId;
    private Long status;

    public UserCUDto(User user) {
        if (user != null) {
            this.userId = user.getUserId();
            this.userName = user.getUserName();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.phoneNumber = user.getPhoneNumber();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.departmentId = user.getDepartmentId();
            this.status = user.getStatus();
        }

    }
}
