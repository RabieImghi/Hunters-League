package org.rabie.hunters_league.service;

import org.rabie.hunters_league.domain.Hunt;
import org.rabie.hunters_league.domain.Species;
import org.rabie.hunters_league.exceptions.HuntException;
import org.rabie.hunters_league.repository.HuntRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HuntService {
    private final HuntRepository huntRepository;
    public HuntService(HuntRepository huntRepository) {
        this.huntRepository = huntRepository;
    }

    public List<Hunt> getBySpecies(Species species) {
        if (species == null)
            throw new HuntException("Species is null");
        return huntRepository.findBySpecies(species);

    }

    @Transactional
    public void deleteBySpeciesId(Species species) {
        if (species == null)
            throw new HuntException("Hunt is null");
        huntRepository.deleteBySpeciesId(species.getId());
    }
}
