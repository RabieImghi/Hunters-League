package org.rabie.hunters_league.web.api;

import jakarta.validation.Valid;
import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.service.CompetitionService;
import org.rabie.hunters_league.web.vm.mapper.CompetitionMapper;
import org.rabie.hunters_league.web.vm.request.CompetitionVm;
import org.rabie.hunters_league.web.vm.response.CompetitionResponseVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competition")
public class CompetitionController {

    private final CompetitionService competitionService;
    private final CompetitionMapper competitionMapper;

    public CompetitionController(CompetitionService competitionService, CompetitionMapper competitionMapper) {
        this.competitionService = competitionService;
        this.competitionMapper = competitionMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<CompetitionResponseVm> createCompetition(@Valid @RequestBody CompetitionVm competitionVm) {
        Competition competition = competitionMapper.toCompetition(competitionVm);
        Competition savedCompetition = competitionService.save(competition);
        return ResponseEntity.ok(competitionMapper.toCompetitionResponseVm(savedCompetition));
    }

}
