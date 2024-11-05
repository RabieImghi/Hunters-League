package org.rabie.hunters_league.web.api;

import jakarta.validation.Valid;
import org.rabie.hunters_league.domain.User;
import org.rabie.hunters_league.service.UserService;
import org.rabie.hunters_league.web.vm.mapper.UserMapper;
import org.rabie.hunters_league.web.vm.request.CreatNewUserVm;
import org.rabie.hunters_league.web.vm.request.LoginVM;
import org.rabie.hunters_league.web.vm.response.UserResponseVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final UserMapper userMapper;

    public AuthController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<CreatNewUserVm> register(@Valid @RequestBody CreatNewUserVm creatNewUserVm) {
        User user = userMapper.toUser(creatNewUserVm);
        User savedUser = userService.save(user);
        return ResponseEntity.ok(userMapper.toUserVm(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseVm> login(@Valid @RequestBody LoginVM loginVM) {
        User user = userMapper.toUserFromLoginVm(loginVM);
        User savedUser = userService.login(user);
        return ResponseEntity.ok(userMapper.toUserResponseVm(savedUser));
    }


}
