package com.titos.balancetogether.controller;

import com.titos.balancetogether.dto.UpdateUserRequest;
import com.titos.balancetogether.dto.UserDto;
import com.titos.balancetogether.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/{id}")
    public List<UserDto> updateUser(
            @PathVariable long id,
            @RequestBody UpdateUserRequest request
    ) {
        return userService.updateUserName(id, request.name());
    }
}
