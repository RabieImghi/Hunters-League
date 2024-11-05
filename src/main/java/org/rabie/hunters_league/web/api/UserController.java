package org.rabie.hunters_league.web.api;

import jakarta.validation.Valid;
import org.rabie.hunters_league.domain.User;
import org.rabie.hunters_league.service.UserService;
import org.rabie.hunters_league.web.vm.mapper.UserMapper;
import org.rabie.hunters_league.web.vm.request.UserUpdateVm;
import org.rabie.hunters_league.web.vm.response.UserResponseVm;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/getAll")
    public Page<UserResponseVm> getUsers(@Valid @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        return userService.getAllUsers(page, size).map(userMapper::toUserResponseVm);
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseVm> updateUser(@Valid @RequestBody UserUpdateVm userUpdateVm) {
        User user = userMapper.toUserFromUpdateVm(userUpdateVm);
        User updatedUser = userService.update(user);
        return ResponseEntity.ok(userMapper.toUserResponseVm(updatedUser));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponseVm> deleteUser(@PathVariable UUID id) {
        User user = userService.getById(id);
        userService.delete(user);
        return ResponseEntity.ok(userMapper.toUserResponseVm(user));
    }
}
