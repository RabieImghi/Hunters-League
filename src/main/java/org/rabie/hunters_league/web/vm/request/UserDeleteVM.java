package org.rabie.hunters_league.web.vm.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserDeleteVM {
    private UUID id;
}
