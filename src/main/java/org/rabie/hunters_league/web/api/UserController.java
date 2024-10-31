package org.rabie.hunters_league.web.api;

import org.rabie.hunters_league.domain.User;
import org.rabie.hunters_league.service.UserService;
import org.rabie.hunters_league.web.vm.mapper.UserMapper;
import org.rabie.hunters_league.web.vm.response.ListUserVm;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Page<ListUserVm> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return userService.getAllUsers(page, size).map(userMapper::toListUserVm);


    }
}
