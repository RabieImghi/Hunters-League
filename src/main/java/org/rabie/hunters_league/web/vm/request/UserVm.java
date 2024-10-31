package org.rabie.hunters_league.web.vm.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.rabie.hunters_league.domain.enums.Role;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserVm {

    @NotBlank(message = "Username is required.")
    private String username;

    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    @Pattern(regexp = ".[a-z].", message = "Password must contain at least one lowercase letter.")
    @Pattern(regexp = ".[A-Z].", message = "Password must contain at least one uppercase letter.")
    @Pattern(regexp = ".[0-9].", message = "Password must contain at least one digit.")
    private String password;

    private Role role;

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotBlank(message = "CIN is required.")
    private String cin;

    @NotBlank(message = "Nationality is required.")
    private String nationality;

    @NotBlank(message = "license Expiration Date date is required.")
    private LocalDateTime licenseExpirationDate;

    @NotBlank(message = "Join date is required.")
    private LocalDateTime joinDate;
}