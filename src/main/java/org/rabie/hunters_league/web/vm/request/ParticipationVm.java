package org.rabie.hunters_league.web.vm.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.domain.User;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.UUID;


@Getter
@AllArgsConstructor
public class ParticipationVm {
    @NonNull
    private UUID userId;
    @NonNull
    private UUID competitionId;
    private Double score;
}
