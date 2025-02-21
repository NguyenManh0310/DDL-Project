package com.common.commonservice.Controller;

import com.common.commonservice.DTO.Category.CategoryCUDto;
import com.common.commonservice.DTO.Category.CategoryDeleteDto;
import com.common.commonservice.DTO.Item.ItemCUDto;
import com.common.commonservice.DTO.Item.ItemDeleteDto;
import com.common.commonservice.Service.DepartmentService;
import com.common.commonservice.Service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/common/item")
public class ItemController {
    final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllCategory() {
        return itemService.getAllItem();
    }

    @GetMapping("/get-item")
    public ResponseEntity<Object> getCategoryById(@RequestParam Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/get-item-by-category-code")
    public ResponseEntity<Object> getCategoryByCategoryCode(@RequestParam String code) {
        return itemService.getListItemByCategoryCode(code);
    }

    @PostMapping("/create-item")
    public ResponseEntity<Object> createCategory(@RequestBody ItemCUDto itemCUDto) {
        return itemService.createItem(itemCUDto);
    }

    @PutMapping("/update-item")
    public ResponseEntity<Object> updateCategory(@RequestBody ItemCUDto itemCUDto) {
        return itemService.updateItem(itemCUDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCategory(@RequestBody List<ItemDeleteDto> itemDeleteDtos) {
        return itemService.deleteItem(itemDeleteDtos);
    }

    @GetMapping("/paging")
    public ResponseEntity<Object> getItemPaging(
            @RequestParam(defaultValue = "0") int first,
            @RequestParam(defaultValue = "10") int rows,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String itemCode,
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) String categoryName) {
        return itemService.getAllItemPaging(first, rows, page, itemCode, itemName, categoryName);
    }
}
