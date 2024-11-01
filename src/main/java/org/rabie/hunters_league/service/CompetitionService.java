package org.rabie.hunters_league.service;

import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.exceptions.CompetitionException;
import org.rabie.hunters_league.repository.CompetitionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        Competition lastCompetition = competitionRepository.findTopByOrderByDateDesc();
        if(lastCompetition!=null && lastCompetition.getDate().isAfter(competition.getDate().minusDays(7)))
            throw new CompetitionException("You can just create a competition every week");
        return competitionRepository.save(competition);
    }
}
