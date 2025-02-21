package com.common.commonservice.Entity;

import com.common.commonservice.DTO.User.UserCUDto;
import com.example.common.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "COMMON.USERS_SEQ", allocationSize = 1)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USERNAME")
    @Size(max = 500)
    private String userName;

    @Column(name = "PASSWORD")
    @Size(max = 500)
    private String password;

    @Column(name = "EMAIL")
    @Size(max = 500)
    private String email;

    @Column(name = "PHONE_NUMBER")
    @Size(max = 50)
    private String phoneNumber;

    @Column(name = "FIRST_NAME")
    @Size(max = 100)
    private String firstName;

    @Column(name = "LAST_NAME")
    @Size(max = 100)
    private String lastName;

    @Column(name = "DEPARTMENT_ID", insertable = false, updatable = false)
    private Long departmentId;

    @Column(name = "STATUS")
    private Long status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    public User(UserCUDto userCUDto) {
        this.email = userCUDto.getEmail();
        this.phoneNumber = userCUDto.getPhoneNumber();
        this.firstName = userCUDto.getFirstName().trim().replaceAll("\\s+", " ");
        this.lastName = userCUDto.getLastName().trim().replaceAll("\\s+", " ");
    }
}
