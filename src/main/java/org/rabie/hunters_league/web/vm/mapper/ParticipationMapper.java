package org.rabie.hunters_league.web.vm.mapper;

import org.mapstruct.Mapper;
import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.domain.Participation;
import org.rabie.hunters_league.web.vm.request.UserResultsVm;
import org.rabie.hunters_league.web.vm.response.ParticipationResponseVm;
import org.rabie.hunters_league.web.vm.response.ParticipationScoreResponseVm;
import org.rabie.hunters_league.web.vm.response.UserResultsResponseVm;

@Mapper(componentModel = "spring")
public interface ParticipationMapper {
    ParticipationResponseVm toParticipationResponseVm(Participation participation);
    ParticipationScoreResponseVm toParticipationScoreResponseVm(Participation participation);


    Participation toCompetitionFromUserResultsVm(UserResultsVm userResultsVm);
    UserResultsResponseVm toUserResultsResponseVm(Participation participation);
}
