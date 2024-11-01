package org.rabie.hunters_league.service;

import org.rabie.hunters_league.domain.Species;
import org.rabie.hunters_league.repository.SpeciesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SpeciesService {
    private final SpeciesRepository speciesRepository;
    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public Page<Species> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return speciesRepository.findAll(pageRequest);
    }
}
