package org.rabie.hunters_league.web.api;

import jakarta.validation.Valid;
import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.service.CompetitionService;
import org.rabie.hunters_league.web.vm.mapper.CompetitionMapper;
import org.rabie.hunters_league.web.vm.request.CompetitionVm;
import org.rabie.hunters_league.web.vm.response.CompetitionResponseVm;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @GetMapping("/details")
    public Page<CompetitionResponseVm> getCompetition(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size ){
        Page<Competition> competitionList = competitionService.findAll(page, size);
        return competitionList.map(competitionMapper::toCompetitionResponseVm);
    }
    @GetMapping("/details/{id}")
    public List<CompetitionResponseVm> getCompetitionById(@PathVariable UUID id){
        Competition competition = competitionService.getById(id);
        CompetitionResponseVm competitionResponseVm = competitionMapper.toCompetitionResponseVm(competition);
        return List.of(competitionResponseVm);
    }
}
