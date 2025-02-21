package com.common.commonservice.Service.ServiceImpl;

import com.common.commonservice.Convert.CommonConvertEntity;
import com.common.commonservice.DTO.Item.ItemCUDto;
import com.common.commonservice.DTO.Item.ItemDeleteDto;
import com.common.commonservice.DTO.Item.ItemDetailDto;
import com.common.commonservice.DTO.Item.ItemPagingDto;
import com.common.commonservice.Entity.Item;
import com.common.commonservice.Repository.CategoryRepository;
import com.common.commonservice.Repository.ItemRepository;
import com.common.commonservice.Service.ItemService;
import com.common.commonservice.Validate.CommonValidateEntity;
import com.example.common.Constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ItemServiceImpl implements ItemService {

    final CommonConvertEntity commonConvertEntity;
    final CommonValidateEntity commonValidateEntity;
    final ItemRepository itemRepository;
    final CategoryRepository categoryRepository;

    @Autowired
    public ItemServiceImpl(CommonConvertEntity commonConvertEntity,
                           CommonValidateEntity commonValidateEntity,
                           ItemRepository itemRepository,
                           CategoryRepository categoryRepository) {
        this.commonConvertEntity = commonConvertEntity;
        this.commonValidateEntity = commonValidateEntity;
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<Object> getAllItem() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonConvertEntity.toItemDetailsDto(itemRepository.getAllItem()));
    }

    @Override
    public ResponseEntity<Object> createItem(ItemCUDto itemCUDto) {
        if (!Objects.requireNonNull(commonValidateEntity.validateItem(itemCUDto, "create").
                getBody()).toString().equals(Message.VALID_DATA))
            return commonValidateEntity.validateItem(itemCUDto, "create");
        Item item = new Item(itemCUDto);

        if (itemCUDto.getCategoryCode() != null) {
            item.setCategoryId(categoryRepository.getByCategoryCode(itemCUDto.getCategoryCode()).getCategoryId());
        }
        item.setStatus(itemCUDto.getStatus());
        item.setCreatedUser(1L);
        item.setCreatedTime(Date.valueOf(LocalDate.now()));
        itemRepository.save(item);
        return ResponseEntity.status(HttpStatus.OK).body(itemCUDto);
    }

    @Override
    public ResponseEntity<Object> updateItem(ItemCUDto itemCUDto) {
        if (!Objects.requireNonNull(commonValidateEntity.validateItem(itemCUDto, "update").
                getBody()).toString().equals(Message.VALID_DATA))
            return commonValidateEntity.validateItem(itemCUDto, "update");
        Item item = itemRepository.getByItemId(itemCUDto.getItemId());
        item.setItemName(itemCUDto.getItemName());
        item.setItemCode(itemCUDto.getItemCode());
        item.setItemValue(itemCUDto.getItemValue());
        item.setParentItemId(itemCUDto.getParentItemId());
        if (itemCUDto.getCategoryCode() != null) {
            item.setCategoryId(categoryRepository.getByCategoryCode(itemCUDto.getCategoryCode()).getCategoryId());
        }
        item.setStatus(itemCUDto.getStatus());
        item.setUpdatedUser(1L);
        item.setUpdatedTime(Date.valueOf(LocalDate.now()));
        return ResponseEntity.status(HttpStatus.OK).body(itemCUDto);
    }

    @Override
    public ResponseEntity<Object> deleteItem(List<ItemDeleteDto> itemDeleteDtos) {
        List<Item> items = new ArrayList<>();
        for (ItemDeleteDto itemDeleteDto : itemDeleteDtos
        ) {
            if (itemDeleteDto.getItemId() == null || itemRepository.getByItemId(itemDeleteDto.getItemId()) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(Message.NOT_EXIST_ITEM + " " + Message.ITEM_DELETED);

            Item item = itemRepository.getByItemId(itemDeleteDto.getItemId());
            items.add(item);
        }
        itemRepository.deleteAll(items);
        return ResponseEntity.status(HttpStatus.OK).body(itemDeleteDtos);
    }

    @Override
    public ResponseEntity<Object> getItemById(Long id) {
        if (id == null || itemRepository.getByItemId(id) == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_ITEM);
        return ResponseEntity.status(HttpStatus.OK).
                body(new ItemDetailDto(itemRepository.getByItemId(id)));
    }

    @Override
    public ResponseEntity<Object> getListItemByCategoryCode(String code) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonConvertEntity.toItemDetailsDto(itemRepository.getListItemByCategoryCode(code)));
    }

    @Override
    public ResponseEntity<Object> getAllItemPaging(int first, int rows, int page, String itemCode, String itemName, String categoryName) {
        Pageable pageable = PageRequest.of(page, rows);
        Page<Item> items = itemRepository.getAllItemPaging(itemCode, itemName, categoryName, pageable);
        if (items.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
        ItemPagingDto itemPagingDto = new ItemPagingDto(items.getTotalElements(),
                commonConvertEntity.toItemDetailsDto(items.getContent()));
        return ResponseEntity.status(HttpStatus.OK).body(itemPagingDto);
    }
}
