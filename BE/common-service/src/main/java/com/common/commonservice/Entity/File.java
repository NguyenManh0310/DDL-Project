package com.common.commonservice.Entity;

import com.example.common.BaseEntity.BaseEntity;
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
@Table(name = "FILE")
public class File extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_seq_gen")
    @SequenceGenerator(name = "file_seq_gen", sequenceName = "COMMON.FILES_SEQ", allocationSize = 1)
    @Column(name = "FILE_ID")
    private Long fileId;

    @Column(name = "FILE_NAME")
    @Size(max = 500)
    private String fileName;

    @Column(name = "FILE_PATH")
    @Size(max = 2000)
    private String filePath;

    @Column(name = "BUSINESS_CODE")
    @Size(max = 100)
    private String businessCode;

    @Column(name = "BUSINESS_ID")
    private Long businessId;

    @Column(name = "STATUS")
    private Long status;

}
