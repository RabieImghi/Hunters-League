package org.rabie.hunters_league.web.vm.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserDeleteVM {
    @NotBlank(message = "Id is required.")
    private UUID id;
}
