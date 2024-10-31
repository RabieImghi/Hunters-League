package org.rabie.hunters_league.web.vm.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVM {
    @NotBlank(message = "Email is required.")
    private String email;


    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    @Pattern(regexp = ".[a-z].", message = "Password must contain at least one lowercase letter.")
    @Pattern(regexp = ".[A-Z].", message = "Password must contain at least one uppercase letter.")
    @Pattern(regexp = ".[0-9].", message = "Password must contain at least one digit.")
    private String password;
}
