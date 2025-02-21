package com.common.commonservice.DTO.Item;

import com.common.commonservice.Entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemCUDto {
    private Long itemId;
    private String itemName;
    private String itemCode;
    private String itemValue;
    private Long parentItemId;
    private String categoryCode;
    private Long status;

    public ItemCUDto(Item item) {
        if (item != null) {
            this.itemId = item.getItemId();
            this.itemCode = item.getItemCode();
            this.itemName = item.getItemName();
            this.itemValue = item.getItemValue();
            this.parentItemId = item.getParentItemId();
            this.status = item.getStatus();
        }
    }
}
