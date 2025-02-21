package com.wfm.wfmservice.Entity;

import com.example.common.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "WO_HISTORY")
public class WoHistory extends BaseEntity {
    @Id
    @Column(name = "WO_HISTORY_ID")
    private Long woHistoryId;

    @Column(name = "WO_ID")
    private Long woId;

    @Column(name = "WO_CODE")
    @Size(max = 100)
    private String woCode;

    @Column(name = "WO_CONTENT",columnDefinition = "CLOB")
    private String woContent;

}
