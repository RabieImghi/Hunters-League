package org.rabie.hunters_league.web.vm.mapper;

import org.mapstruct.Mapper;
import org.rabie.hunters_league.domain.Participation;
import org.rabie.hunters_league.web.vm.response.ParticipationResponseVm;

@Mapper(componentModel = "spring")
public interface ParticipationMapper {
    ParticipationResponseVm toParticipationResponseVm(Participation participation);
}
