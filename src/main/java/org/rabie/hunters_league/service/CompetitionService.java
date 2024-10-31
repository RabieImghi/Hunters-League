package org.rabie.hunters_league.service;

import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.repository.CompetitionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public Competition getById(UUID id) {
        return competitionRepository.findById(id).orElse
                (new Competition());
    }

    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }
}
