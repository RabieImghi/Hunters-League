package org.rabie.hunters_league.web.vm.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.domain.User;

import java.util.UUID;


@Getter
@AllArgsConstructor
public class ParticipationVm {
    private UUID userId;
    private UUID competitionId;
    private Double score;
}
