package com.common.commonservice.Entity;

import com.common.commonservice.DTO.Item.ItemCUDto;
import com.example.common.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ITEM")
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_gen")
    @SequenceGenerator(name = "item_seq_gen", sequenceName = "COMMON.ITEM_SEQ", allocationSize = 1)
    @Column(name = "ITEM_ID")
    private Long itemId;

    @Column(name = "ITEM_NAME")
    @Size(max = 500)
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

    public Item(ItemCUDto itemCUDto) {
        if (itemCUDto != null) {
            this.itemName = itemCUDto.getItemName();
            this.itemCode = itemCUDto.getItemCode();
            this.itemValue = itemCUDto.getItemValue();
            this.parentItemId=itemCUDto.getParentItemId();
        }
    }
}
