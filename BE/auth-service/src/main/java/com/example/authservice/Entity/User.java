package com.example.authservice.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


}
