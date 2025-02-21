package com.common.commonservice.Service;

import com.common.commonservice.DTO.User.UserChangePasswordDto;
import com.common.commonservice.DTO.User.UserCUDto;
import com.common.commonservice.DTO.User.UserDeleteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<Object> getAll();
    ResponseEntity<Object> createUser(UserCUDto userCUDto);
    ResponseEntity<Object> updateUser(UserCUDto userCUDto);
    ResponseEntity<Object> getUserById(Long id);
    ResponseEntity<Object> deleteUser(List<UserDeleteDto> userDeleteDtos);
    ResponseEntity<Object> changePassword(UserChangePasswordDto userChangePasswordDto);
    ResponseEntity<Object> getAllUserPaging(int first, int rows, int page,
                                            String email, String phoneNumber,
                                            String userName,String name);
}
