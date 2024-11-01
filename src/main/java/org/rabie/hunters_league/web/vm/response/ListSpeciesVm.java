package org.rabie.hunters_league.web.vm.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.rabie.hunters_league.domain.enums.Difficulty;
import org.rabie.hunters_league.domain.enums.SpeciesType;

@Getter
@Setter
public class ListSpeciesVm {
    private String name;
    private SpeciesType category;
    private Double minimumWeight;
    private Difficulty difficulty;
    private Integer points;
}
