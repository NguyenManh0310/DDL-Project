package com.common.commonservice.Validate;

import com.common.commonservice.DTO.Category.CategoryCUDto;
import com.common.commonservice.DTO.Department.DepartmentCUDto;
import com.common.commonservice.DTO.Item.ItemCUDto;
import com.common.commonservice.DTO.User.UserCUDto;
import com.common.commonservice.Repository.CategoryRepository;
import com.common.commonservice.Repository.DepartmentRepository;
import com.common.commonservice.Repository.ItemRepository;
import com.common.commonservice.Repository.UserRepository;
import com.example.common.Constant.Message;
import com.example.common.Constant.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CommonValidateEntity {
    final UserRepository userRepository;
    final DepartmentRepository departmentRepository;
    final CategoryRepository categoryRepository;
    final ItemRepository itemRepository;

    @Autowired
    public CommonValidateEntity(UserRepository userRepository,
                                DepartmentRepository departmentRepository,
                                CategoryRepository categoryRepository,
                                ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
    }

    public ResponseEntity<Object> validateUser(UserCUDto userCUDto, String option) {

        if (option.equals("create") || option.equals("update")) {

            // Blank information
            if (userCUDto == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_DATA);


            if (userCUDto.getEmail() == null || userCUDto.getEmail().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_EMAIL);

            if (userCUDto.getPhoneNumber() == null || userCUDto.getPhoneNumber().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_PHONE_NUMBER);

            if (userCUDto.getFirstName() == null || userCUDto.getFirstName().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_FIRST_NAME);

            if (userCUDto.getLastName() == null || userCUDto.getLastName().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_LAST_NAME);

            if (userCUDto.getStatus() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_STATUS);

            if (userCUDto.getStatus() != 0L && userCUDto.getStatus() != 1L)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_STATUS);

            // Invalid

            if (!userCUDto.getEmail().matches(Condition.REGEX_EMAIL) ||
                    userCUDto.getEmail().trim().length() > Condition.MAX_LENGTH_EMAIL)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_EMAIL);

            if (!userCUDto.getPhoneNumber().matches(Condition.REGEX_PHONE))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_PHONE_NUMBER);

            if (!userCUDto.getFirstName().matches(Condition.REGEX_NAME) ||
                    !userCUDto.getLastName().matches(Condition.REGEX_NAME) ||
                    userCUDto.getFirstName().length() > Condition.MAX_LENGTH_FIRST_NAME ||
                    userCUDto.getLastName().length() > Condition.MAX_LENGTH_LAST_NAME)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_NAME);


            // Not Exist

            if (userCUDto.getDepartmentId() != null
                    && departmentRepository.getByDepartmentId(userCUDto.getDepartmentId()) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_DEPARTMENT);

            // Exist
            if (option.equals("create")) {
                if (userCUDto.getUserName() == null || userCUDto.getUserName().trim().equals(""))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_USERNAME);

                if (userCUDto.getPassword() == null || userCUDto.getPassword().trim().equals(""))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_PASSWORD);

                if (!userCUDto.getUserName().matches(Condition.REGEX_USERNAME) ||
                        userCUDto.getUserName().trim().length() > Condition.MAX_LENGTH_USERNAME)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_USERNAME);

                if (!userCUDto.getPassword().matches(Condition.REGEX_PASSWORD))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_PASSWORD);

                if (userRepository.existsByUserName(userCUDto.getUserName()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_USERNAME);

                if (userRepository.existsByEmail(userCUDto.getEmail()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_EMAIL);

                if (userRepository.existsByPhoneNumber(userCUDto.getPhoneNumber()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_PHONE_NUMBER);
            }

            if (option.equals("update")) {
                if (userCUDto.getUserId() == null || userRepository.getUserByUserId(userCUDto.getUserId()) == null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_USER);

                if (userRepository.existsByEmail(userCUDto.getEmail()) &&
                        !userRepository.getUserByEmail(userCUDto.getEmail()).getUserId().equals(userCUDto.getUserId()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_EMAIL);

                if (userRepository.existsByPhoneNumber(userCUDto.getPhoneNumber()) &&
                        !userRepository.getUserByPhoneNumber(userCUDto.getPhoneNumber()).getUserId().equals(userCUDto.getUserId()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_PHONE_NUMBER);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(Message.VALID_DATA);
    }

    public ResponseEntity<Object> validateDepartment(DepartmentCUDto departmentCUDto, String option) {
        if (option.equals("create") || option.equals("update")) {
            if (departmentCUDto == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_DATA);

            if (departmentCUDto.getDepartmentCode() == null || departmentCUDto.getDepartmentCode().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_DEPARTMENT_CODE);

            if (departmentCUDto.getDepartmentName() == null || departmentCUDto.getDepartmentName().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_DEPARTMENT_NAME);

            if (departmentCUDto.getStatus() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_STATUS);

            if (departmentCUDto.getStatus() != 0L && departmentCUDto.getStatus() != 1L)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_STATUS);

            if (departmentCUDto.getDepartmentCode().length() > Condition.MAX_LENGTH_DEPARTMENT_CODE)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_DEPARTMENT_CODE);

            if (departmentCUDto.getDepartmentName().length() > Condition.MAX_LENGTH_DEPARTMENT_NAME)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_DEPARTMENT_NAME);

            if (departmentCUDto.getParentDepartmentId() != null &&
                    departmentRepository.getByDepartmentId(departmentCUDto.getParentDepartmentId()) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_PARENT_DEPARTMENT);

            if (option.equals("create")) {
                if (departmentRepository.getByDepartmentCode(departmentCUDto.getDepartmentCode()) != null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_DEPARTMENT_CODE);
            }

            if (option.equals("update")) {
                if (departmentCUDto.getDepartmentId() == null
                        || departmentRepository.getByDepartmentId(departmentCUDto.getDepartmentId()) == null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_DEPARTMENT);

                if (departmentRepository.getByDepartmentCode(departmentCUDto.getDepartmentCode()) != null &&
                        !departmentRepository.
                                getByDepartmentCode(departmentCUDto.getDepartmentCode()).getDepartmentId().
                                equals(departmentCUDto.getDepartmentId()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_DEPARTMENT_CODE);


            }


        }

        return ResponseEntity.status(HttpStatus.OK).body(Message.VALID_DATA);
    }

    public ResponseEntity<Object> validateCategory(CategoryCUDto categoryDto, String option) {
        if (option.equals("create") || option.equals("update")) {
            if (categoryDto == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_DATA);

            if (categoryDto.getCategoryCode() == null || categoryDto.getCategoryCode().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_CATEGORY_CODE);

            if (categoryDto.getCategoryName() == null || categoryDto.getCategoryName().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_CATEGORY_NAME);

            if (categoryDto.getStatus() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_STATUS);

            if (categoryDto.getStatus() != 0L && categoryDto.getStatus() != 1L)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_STATUS);

            if (categoryDto.getCategoryCode().length() > Condition.MAX_LENGTH_CATEGORY_CODE)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_CATEGORY_CODE);

            if (categoryDto.getCategoryName().length() > Condition.MAX_LENGTH_CATEGORY_NAME)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_CATEGORY_NAME);

            if (option.equals("create")) {
                if (categoryRepository.getByCategoryCode(categoryDto.getCategoryCode()) != null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_CATEGORY_CODE);
            }

            if (option.equals("update")) {
                if (categoryDto.getCategoryId() == null
                        || categoryRepository.getByCategoryId(categoryDto.getCategoryId()) == null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_CATEGORY);

                if (categoryRepository.getByCategoryCode(categoryDto.getCategoryCode()) != null &&
                        !categoryRepository.
                                getByCategoryCode(categoryDto.getCategoryCode()).getCategoryId().
                                equals(categoryDto.getCategoryId()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_CATEGORY_CODE);

            }

        }

        return ResponseEntity.status(HttpStatus.OK).body(Message.VALID_DATA);
    }

    public ResponseEntity<Object> validateItem(ItemCUDto itemCUDto, String option) {
        if (option.equals("create") || option.equals("update")) {
            if (itemCUDto == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_DATA);

            if (itemCUDto.getItemName() == null || itemCUDto.getItemName().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_ITEM_NAME);

            if (itemCUDto.getItemCode() == null || itemCUDto.getItemCode().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_ITEM_CODE);

            if (itemCUDto.getItemValue() == null || itemCUDto.getItemValue().trim().equals(""))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_ITEM_VALUE);

            if (itemCUDto.getStatus() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_STATUS);

            if (itemCUDto.getStatus() != 0L && itemCUDto.getStatus() != 1L)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_STATUS);

            if (itemCUDto.getItemName().length() > Condition.MAX_LENGTH_ITEM_NAME)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_ITEM_NAME);

            if (itemCUDto.getItemCode().length() > Condition.MAX_LENGTH_ITEM_CODE)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_ITEM_CODE);

            if (itemCUDto.getItemValue().length() > Condition.MAX_LENGTH_ITEM_VALUE)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_ITEM_VALUE);

            if (itemCUDto.getParentItemId() != null &&
                    itemRepository.getByItemId(itemCUDto.getParentItemId()) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_PARENT_ITEM);
            if (itemCUDto.getCategoryCode() != null &&
                    categoryRepository.getByCategoryCode(itemCUDto.getCategoryCode()) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_CATEGORY);

            if (option.equals("create")) {
                if (itemRepository.getByItemCode(itemCUDto.getItemCode()) != null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_ITEM_CODE);
            }

            if (option.equals("update")) {
                if (itemCUDto.getItemId() == null
                        || itemRepository.getByItemId(itemCUDto.getItemId()) == null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_ITEM);

                if (itemRepository.getByItemCode(itemCUDto.getItemCode()) != null &&
                        !itemRepository.
                                getByItemCode(itemCUDto.getItemCode()).getItemId().
                                equals(itemCUDto.getItemId()))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.EXIST_ITEM_CODE);

            }

        }

        return ResponseEntity.status(HttpStatus.OK).body(Message.VALID_DATA);
    }
}
