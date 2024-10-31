package org.rabie.hunters_league.web.vm.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.rabie.hunters_league.domain.Participation;
import org.rabie.hunters_league.domain.enums.Role;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ListUserVm {
    private UUID id;
    private String username;
    private String email;
    private Role role;
    private String firstName;
    private String lastName;
}
