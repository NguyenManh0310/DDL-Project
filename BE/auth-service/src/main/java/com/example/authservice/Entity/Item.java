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
@Table(name = "ITEM")
public class Item extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_gen")
    @SequenceGenerator(name = "item_seq_gen", sequenceName = "COMMON.ITEM_SEQ", allocationSize = 1)
    @Column(name = "ITEM_ID")
    private Long itemId;

    @Column(name = "ITEM_NAME")
    @Size(max=500)
    private String itemName;

    @Column(name = "ITEM_CODE")
    @Size(max = 100)
    private String itemCode;

    @Column(name = "ITEM_VALUE")
    @Size(max = 500)
    private String itemValue;

    @Column(name = "PARENT_ITEM_ID")
    private Long parentItemId;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "STATUS")
    private Long status;


}
