package org.rabie.hunters_league.web.vm.mapper;

import org.mapstruct.Mapper;
import org.rabie.hunters_league.domain.Species;
import org.rabie.hunters_league.web.vm.request.SpeciesCreateVm;
import org.rabie.hunters_league.web.vm.response.SpecieResponseVm;

@Mapper(componentModel = "spring")
public interface SpeciesMapper {
    SpecieResponseVm toListSpeciesVm(Species species);
    Species toSpecies(SpecieResponseVm speciesVm);

    SpeciesCreateVm toSpeciesCreateVm(Species species);
    Species toSpeciesFromCreate(SpeciesCreateVm speciesVm);

}
