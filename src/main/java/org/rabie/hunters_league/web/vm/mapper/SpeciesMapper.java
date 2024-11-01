package org.rabie.hunters_league.web.vm.mapper;

import org.mapstruct.Mapper;
import org.rabie.hunters_league.domain.Species;
import org.rabie.hunters_league.web.vm.response.ListSpeciesVm;

@Mapper(componentModel = "spring")
public interface SpeciesMapper {
    ListSpeciesVm toListSpeciesVm(Species species);

}
