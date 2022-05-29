package com.zun.rest.controller;

import com.zun.domain.User;
import com.zun.rest.dto.UserDto;
import com.zun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
    public List<UserDto> getAllUser() {
        return userService.getAll().stream().map(UserDto::toDto).collect(Collectors.toList());
    }

    @PostMapping("/user")
    public UserDto insertUser(@RequestParam UserDto userDto) {
        User user = userService.insert(UserDto.toDomainObject(userDto));
        return UserDto.toDto(user);
    }

    @PutMapping("user/{id}")
    public  UserDto update(@PathVariable int id,
                           @RequestParam String name){
        User user = userService.update(id,name);
        return UserDto.toDto(user);
    }

    @DeleteMapping("/user{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteById(id);
    }
    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable int id){
        User user = userService.getById(id);
        return UserDto.toDto(user);
    }
}