package org.rabie.hunters_league.service;

import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.repository.CompetitionRepository;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }
}
