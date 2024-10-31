package org.rabie.hunters_league.service;

import org.rabie.hunters_league.domain.Participation;
import org.rabie.hunters_league.repository.ParticipationRepository;
import org.springframework.stereotype.Service;

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
    public Participation save(Participation participation) {
        return participationRepository.save(participation);
    }


}
