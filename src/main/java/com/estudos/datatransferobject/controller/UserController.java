package com.estudos.datatransferobject.controller;

import com.estudos.datatransferobject.dto.CreateUserDto;
import com.estudos.datatransferobject.dto.DeleteUserDto;
import com.estudos.datatransferobject.dto.UpdateUserDto;
import com.estudos.datatransferobject.entity.User;
import com.estudos.datatransferobject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UUID> createUser(@Valid @RequestBody CreateUserDto userDto) {
        var savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        var listUsers = userService.getUsers();
        return ResponseEntity.ok(listUsers);
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> deleteUsers(@Valid @RequestBody DeleteUserDto ids) {
        userService.deleteUsers(ids);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        var userById = userService.getUserById(userId);
        return userById.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable("userId") String userId,
                                           @Valid @RequestBody UpdateUserDto updateUserDto) {
        userService.updateUserById(userId, updateUserDto);
        return ResponseEntity.noContent().build();
    }

}
