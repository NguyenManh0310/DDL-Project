package com.example.common.BaseEntity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityDto {
    private Date createdTime;
    private Date updatedTime;
    private Long createdUser;
    private Long updatedUser;

    public void setCreatedUser(Long createdUser) {
        this.createdUser = createdUser;
    }

    public Long getCreatedUser() {
        return createdUser;
    }

    public void setUpdatedUser(Long updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Long getUpdatedUser() {
        return updatedUser;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }
}
