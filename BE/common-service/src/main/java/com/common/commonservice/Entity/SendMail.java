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
@Table(name = "SEND_MAIL")
public class SendMail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "send_mail_seq_gen")
    @SequenceGenerator(name = "send_mail_seq_gen", sequenceName = "COMMON.SEND_MAIL_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CONTENT",columnDefinition = "CLOB")
    private String content;

    @Column(name = "MAIL_TO")
    @Size(max = 500)
    private String mailTo;

    @Column(name = "STATUS")
    private Long status;


}
