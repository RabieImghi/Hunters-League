package org.rabie.hunters_league.web.vm.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.UniqueElements;
import org.rabie.hunters_league.domain.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserUpdateVm {
    @NotBlank(message = "Id is required.")
    private UUID id;

    @NotBlank(message = "Username is required.")
    @UniqueElements
    private String username;

    @NotBlank(message = "Email is required.")
    @UniqueElements
    private String email;

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
}
