package org.rabie.hunters_league.web.vm.response;

import lombok.Getter;
import lombok.Setter;
import org.rabie.hunters_league.domain.User;

@Getter
@Setter
public class UserResultsResponseVm {
    private ListUserVm user;
    private CompetitionResponseVm competition;
    private Double score;
}
