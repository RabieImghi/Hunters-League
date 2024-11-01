package org.rabie.hunters_league.service;

import lombok.NonNull;
import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.domain.Participation;
import org.rabie.hunters_league.exceptions.CompetitionException;
import org.rabie.hunters_league.exceptions.LicenceUserExpiredException;
import org.rabie.hunters_league.exceptions.UserNotExistException;
import org.rabie.hunters_league.repository.ParticipationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ParticipationService {
    private final ParticipationRepository participationRepository;

    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public Participation getById(UUID id) {
        return participationRepository.findById(id).orElse
                (new Participation());
    }
    public Participation save(@NonNull Participation participation) {
        Participation searchParticipation = participationRepository.findByUserAndCompetition(participation.getUser(), participation.getCompetition());
        if(searchParticipation != null)
            throw new CompetitionException("User already registered in this competition");
        if(!participation.getUser().getLicenseExpirationDate().isAfter(LocalDateTime.now()))
            throw new LicenceUserExpiredException("User license has expired");
        if (participation.getUser() == null)
            throw new UserNotExistException("User does not exist");
        if(!participation.getCompetition().getOpenRegistration())
            throw new CompetitionException("Competition is closed for registration");
        if(participation.getCompetition().getDate().isBefore(LocalDateTime.now()))
            throw new CompetitionException("Competition has ended");
        if(participation.getCompetition() == null)
            throw new CompetitionException("Competition does not exist");
        return participationRepository.save(participation);
    }


}
