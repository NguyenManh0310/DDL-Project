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
@Table(name = "CONFIG_VIEW")
public class ConfigView extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "config_view_seq_gen")
    @SequenceGenerator(name = "config_view_seq_gen", sequenceName = "COMMON.CONFIG_VIEW_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "VIEW_NAME")
    @Size(max = 500)
    private String viewName;

    @Column(name = "VIEW_PATH")
    @Size(max = 500)
    private String viewPath;

    @Column(name = "API_PATH")
    @Size(max = 500)
    private String apiPath;

    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "STATUS")
    private Long status;

}
