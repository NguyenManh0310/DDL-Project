package com.common.commonservice.Controller;

import com.common.commonservice.DTO.User.UserCUDto;
import com.common.commonservice.Service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/common/user")
@Tag(name = "User Controller", description = "APIs for User Controller")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAll() {
        return userService.getAll();
    }

    @PostMapping("/create-user")
    public ResponseEntity<Object> createUser(@RequestBody UserCUDto userCUDto) {
        return userService.createUser(userCUDto);
    }

    @PutMapping("/update-user")
    public ResponseEntity<Object> updateUser(@RequestBody UserCUDto userCUDto) {
        return userService.updateUser(userCUDto);
    }

    @GetMapping("/get-user")
    public ResponseEntity<Object> getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteUsers(@RequestBody List<UserCUDto> userCUDtos) {
        return userService.deleteUser(userCUDtos);
    }

    @GetMapping("/paging")
    public ResponseEntity<Object> getUserPaging(
            @RequestParam(defaultValue = "0") int first,
            @RequestParam(defaultValue = "10") int rows,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String name) {
        return userService.getAllUserPaging(first, rows, page, email, phoneNumber, userName, name);
    }
}