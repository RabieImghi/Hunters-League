package org.rabie.hunters_league.web.vm.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.domain.User;

import java.util.UUID;


@Getter
@Setter
public class ParticipationResponseVm {
    private UUID id;
    private UserResponseVm user;
    private CompetitionResponseVm competition;
    private Double score;
}
