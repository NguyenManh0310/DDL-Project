package com.common.commonservice.Service.ServiceImpl;

import com.common.commonservice.DTO.User.*;
import com.example.common.Constant.Condition;
import com.example.common.Constant.Message;
import com.common.commonservice.Convert.CommonConvertEntity;
import com.common.commonservice.Entity.Department;
import com.common.commonservice.Entity.User;
import com.common.commonservice.Repository.DepartmentRepository;
import com.common.commonservice.Repository.UserRepository;
import com.common.commonservice.Service.UserService;

import com.common.commonservice.Validate.CommonValidateEntity;
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
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final CommonConvertEntity commonConvertEntity;
    final CommonValidateEntity commonValidateEntity;
    final DepartmentRepository departmentRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           CommonConvertEntity commonConvertEntity,
                           CommonValidateEntity commonValidateEntity,
                           DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.commonConvertEntity = commonConvertEntity;
        this.commonValidateEntity = commonValidateEntity;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonConvertEntity.toUserDtoDetailResponses(userRepository.getAll()));
    }

    @Override
    public ResponseEntity<Object> createUser(UserCUDto userCUDto) {
        if (!Objects.requireNonNull(commonValidateEntity.validateUser(userCUDto, "create").
                getBody()).toString().equals(Message.VALID_DATA))
            return commonValidateEntity.validateUser(userCUDto, "create");

        User user = new User(userCUDto);

        user.setUserName(userCUDto.getUserName());
        user.setStatus(userCUDto.getStatus());
        user.setCreatedUser(1L);
        user.setCreatedTime(Date.valueOf(LocalDate.now()));

        if (userCUDto.getDepartmentId() != null) {
            Department department = departmentRepository.getByDepartmentId(userCUDto.getDepartmentId());
            user.setDepartment(department);
        }
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(userCUDto);
    }

    @Override
    public ResponseEntity<Object> updateUser(UserCUDto userCUDto) {
        if (!Objects.requireNonNull(commonValidateEntity.validateUser(userCUDto, "update").
                getBody()).toString().equals(Message.VALID_DATA))
            return commonValidateEntity.validateUser(userCUDto, "update");

        User user = userRepository.getUserByUserId(userCUDto.getUserId());
        user.setEmail(userCUDto.getEmail());
        user.setPhoneNumber(userCUDto.getPhoneNumber());
        user.setLastName(userCUDto.getLastName());
        user.setFirstName(userCUDto.getFirstName());
        user.setUpdatedUser(1L);
        user.setUpdatedTime(Date.valueOf(LocalDate.now()));
        user.setStatus(userCUDto.getStatus());

        if (userCUDto.getDepartmentId() != null) {
            Department department = departmentRepository.getByDepartmentId(userCUDto.getDepartmentId());
            user.setDepartment(department);
        }
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(userCUDto);
    }

    @Override
    public ResponseEntity<Object> getUserById(Long id) {
        if (id == null || userRepository.getUserByUserId(id) == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_USER);

        return ResponseEntity.status(HttpStatus.OK).
                body(new UserCUDto(userRepository.getUserByUserId(id)));
    }

    @Override
    public ResponseEntity<Object> deleteUser(List<UserDeleteDto> userDeleteDtos) {
        List<User> users = new ArrayList<>();
        for (UserDeleteDto userDeleteDto : userDeleteDtos
        ) {
            if (userDeleteDto.getUserId() == null || userRepository.getUserByUserId(userDeleteDto.getUserId()) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(Message.NOT_EXIST_USER + " " + Message.USER_DELETED);

            User user = userRepository.getUserByUserId(userDeleteDto.getUserId());
            users.add(user);
        }
        userRepository.deleteAll(users);
        return ResponseEntity.status(HttpStatus.OK).body(userDeleteDtos);
    }

    @Override
    public ResponseEntity<Object> changePassword(UserChangePasswordDto userDto) {

        if (userDto == null || userDto.getId() == null || !userRepository.existsById(userDto.getId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_EXIST_USER);
        if (userDto.getPassword() == null || userDto.getPassword().trim().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NULL_PASSWORD);
        if (!userDto.getPassword().matches(Condition.REGEX_PASSWORD))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.INVALID_PASSWORD);

        User user = userRepository.getUserByUserId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setUpdatedTime(Date.valueOf(LocalDate.now()));
        user.setUpdatedUser(1L);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @Override
    public ResponseEntity<Object> getAllUserPaging(int first, int rows, int page,
                                                   String email, String phoneNumber, String userName, String name) {
        Pageable pageable = PageRequest.of(page, rows);
        Page<UserDetailDto> userDtoDetailResponses =
                userRepository.getAllUserPaging(email, phoneNumber, userName, name, pageable);
        if (userDtoDetailResponses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
        UserPagingDto userPagingDto = new UserPagingDto(userDtoDetailResponses.getTotalElements(),
                userDtoDetailResponses.getContent());
        return ResponseEntity.status(HttpStatus.OK).body(userPagingDto);
    }
}
