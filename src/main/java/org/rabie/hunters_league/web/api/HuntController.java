package org.rabie.hunters_league.web.api;

import jakarta.validation.Valid;
import org.rabie.hunters_league.domain.Hunt;
import org.rabie.hunters_league.domain.Participation;
import org.rabie.hunters_league.domain.Species;
import org.rabie.hunters_league.exceptions.HuntException;
import org.rabie.hunters_league.exceptions.SpeciesException;
import org.rabie.hunters_league.service.HuntService;
import org.rabie.hunters_league.service.ParticipationService;
import org.rabie.hunters_league.service.SpeciesService;
import org.rabie.hunters_league.web.vm.mapper.HuntMapper;
import org.rabie.hunters_league.web.vm.request.HuntRequestVm;
import org.rabie.hunters_league.web.vm.response.HuntResponseVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hunt")
public class HuntController {

    private final HuntService huntService;
    private final SpeciesService speciesService;
    private final ParticipationService participationService;
    private final HuntMapper huntMapper;

    public HuntController(HuntService huntService, HuntMapper huntMapper, SpeciesService speciesService, ParticipationService participationService) {
        this.huntService = huntService;
        this.huntMapper = huntMapper;
        this.speciesService = speciesService;
        this.participationService = participationService;
    }

    @PostMapping("/create")
    public ResponseEntity<HuntResponseVm> createHunt(@Valid @RequestBody HuntRequestVm huntRequestVm){
        Species species = speciesService.getById(huntRequestVm.getSpeciesId());
        Participation participation = participationService.getById(huntRequestVm.getParticipationId());
        Hunt hunt = new Hunt();
        hunt.setSpecies(species);
        hunt.setParticipation(participation);
        hunt.setWeight(huntRequestVm.getWeight());
        Hunt createdHunt = huntService.createHunt(hunt);
        HuntResponseVm huntResponseVm = huntMapper.toHuntResponseVm(createdHunt);
        return ResponseEntity.ok(huntResponseVm);
    }


}
