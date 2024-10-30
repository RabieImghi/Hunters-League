package org.rabie.hunters_league.web.vm.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.rabie.hunters_league.domain.enums.Role;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserVm {
    private String username;
    private String email;
    private String password;
    private Role role;
    private String firstName;
    private String lastName;
    private String cin;
    private String nationality;
    private LocalDateTime joinDate;
    private LocalDateTime licenseExpirationDate;
}