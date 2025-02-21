package com.common.commonservice.Convert;

import com.common.commonservice.DTO.Category.CategoryDetailDto;
import com.common.commonservice.DTO.Department.DepartmentDetailDTO;
import com.common.commonservice.DTO.Item.ItemDetailDto;
import com.common.commonservice.DTO.User.UserDetailDto;
import com.common.commonservice.Entity.Category;
import com.common.commonservice.Entity.Department;
import com.common.commonservice.Entity.Item;
import com.common.commonservice.Entity.User;
import com.common.commonservice.Repository.CategoryRepository;
import com.common.commonservice.Repository.DepartmentRepository;
import com.common.commonservice.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommonConvertEntity {
    private final CategoryRepository categoryRepository;
    private final DepartmentRepository departmentRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public CommonConvertEntity(CategoryRepository categoryRepository,
                               DepartmentRepository departmentRepository,
                               ItemRepository itemRepository) {
        this.categoryRepository = categoryRepository;
        this.departmentRepository = departmentRepository;
        this.itemRepository = itemRepository;
    }


    public List<UserDetailDto> toUserDtoDetailResponses(List<User> users) {
        List<UserDetailDto> list = new ArrayList<>();
        for (User user : users
        ) {
            list.add(new UserDetailDto(user));
        }
        return list;
    }

    //////////Department
    public DepartmentDetailDTO toDepartmentDetailDto(Department department) {
        DepartmentDetailDTO departmentDetailDTO = new DepartmentDetailDTO(department);
        if (department.getParentDepartmentId() != null
                && departmentRepository.existsById(department.getParentDepartmentId())) {
            departmentDetailDTO.setParentDepartmentName
                    (departmentRepository.getByDepartmentId(department.getParentDepartmentId()).getDepartmentName());
        }
        return departmentDetailDTO;
    }

    public List<DepartmentDetailDTO> toDepartmentDetailsDto(List<Department> departments) {
        List<DepartmentDetailDTO> list = new ArrayList<>();
        for (Department department : departments
        ) {
            list.add(toDepartmentDetailDto(department));
        }
        return list;
    }

    //////////Category
    public List<CategoryDetailDto> toCategoryDetailDto(List<Category> categories) {
        List<CategoryDetailDto> list = new ArrayList<>();
        for (Category category : categories
        ) {
            list.add(new CategoryDetailDto(category));
        }
        return list;
    }

    ////////////Item
    public ItemDetailDto toItemDetailDto(Item item) {
        ItemDetailDto itemDetailDto = new ItemDetailDto(item);
        if (item.getCategoryId() != null && categoryRepository.existsByCategoryId(item.getCategoryId())) {
            itemDetailDto.setCategoryName(categoryRepository.getByCategoryId(item.getCategoryId()).getCategoryName());
        }
        if (item.getParentItemId() != null && itemRepository.existsById(item.getParentItemId())) {
            itemDetailDto.setParentItemName(itemRepository.getByItemId(item.getParentItemId()).getItemName());
        }

        return itemDetailDto;
    }

    public List<ItemDetailDto> toItemDetailsDto(List<Item> items) {
        List<ItemDetailDto> list = new ArrayList<>();
        for (Item item : items
        ) {
            list.add(toItemDetailDto(item));
        }
        return list;
    }
}
