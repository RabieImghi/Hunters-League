package org.rabie.hunters_league.web.vm.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.rabie.hunters_league.domain.enums.SpeciesType;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CompetitionVm {
    @NonNull
    @NotBlank
    private String code;
    @NonNull
    @NotBlank
    private String location;
    @NonNull
    @NotBlank
    private LocalDateTime date;
    @NonNull
    @NotBlank
    private SpeciesType speciesType;
    @NonNull
    @NotBlank
    private Integer minParticipants;
    @NonNull
    @NotBlank
    private Integer maxParticipants;
    @NonNull
    @NotBlank
    private Boolean openRegistration;
}
