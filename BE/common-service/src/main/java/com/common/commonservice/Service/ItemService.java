package com.common.commonservice.Service;

import com.common.commonservice.DTO.Item.ItemCUDto;
import com.common.commonservice.DTO.Item.ItemDeleteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    ResponseEntity<Object> getAllItem();
    ResponseEntity<Object> createItem(ItemCUDto itemCUDto);
    ResponseEntity<Object> updateItem(ItemCUDto itemCUDto);
    ResponseEntity<Object> deleteItem(List<ItemDeleteDto> list);
    ResponseEntity<Object> getItemById(Long id);
    ResponseEntity<Object> getListItemByCategoryCode(String code);
    ResponseEntity<Object> getAllItemPaging(int first, int rows, int page,String itemCode,String itemName,String categoryName);
}
