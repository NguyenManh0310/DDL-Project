package com.common.commonservice.DTO.Item;

import com.common.commonservice.Entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.common.BaseEntity.BaseEntityDto;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDetailDto extends BaseEntityDto{
    private Long itemId;
    private String itemName;
    private String itemCode;
    private String itemValue;
    private String parentItemName;
    private String categoryName;
    private Long status;
    public ItemDetailDto(Item item) {
        if (item != null) {
            this.itemId = item.getItemId();
            this.itemCode = item.getItemCode();
            this.itemName = item.getItemName();
            this.itemValue = item.getItemValue();
            this.status = item.getStatus();
            super.setCreatedUser(item.getCreatedUser());
            super.setUpdatedUser(item.getUpdatedUser());
            super.setCreatedTime(item.getCreatedTime());
            super.setUpdatedTime(item.getUpdatedTime());
        }
    }
}
