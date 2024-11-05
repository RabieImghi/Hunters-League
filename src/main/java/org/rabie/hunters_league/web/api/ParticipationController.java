package org.rabie.hunters_league.web.api;

import jakarta.validation.Valid;
import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.domain.Participation;
import org.rabie.hunters_league.domain.User;
import org.rabie.hunters_league.exceptions.CompetitionNotExistException;
import org.rabie.hunters_league.exceptions.LicenceUserExpiredException;
import org.rabie.hunters_league.exceptions.UserNotExistException;
import org.rabie.hunters_league.service.CompetitionService;
import org.rabie.hunters_league.service.HuntService;
import org.rabie.hunters_league.service.ParticipationService;
import org.rabie.hunters_league.service.UserService;
import org.rabie.hunters_league.web.vm.mapper.ParticipationMapper;
import org.rabie.hunters_league.web.vm.request.ParticipationVm;
import org.rabie.hunters_league.web.vm.response.ParticipationResponseVm;
import org.rabie.hunters_league.web.vm.response.ParticipationScoreResponseVm;
import org.rabie.hunters_league.web.vm.response.UserResultsResponseVm;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/participation")
public class ParticipationController {
    private final ParticipationService participationService;
    private final ParticipationMapper participationMapper;
    private final CompetitionService competitionService;
    private final HuntService huntService;
    private final UserService userService;

    public ParticipationController(ParticipationService participationService, ParticipationMapper participationMapper, CompetitionService competitionService,
                                    UserService userService, HuntService huntService)
    {
        this.participationService = participationService;
        this.participationMapper = participationMapper;
        this.competitionService = competitionService;
        this.userService = userService;
        this.huntService = huntService;
    }

    @GetMapping("/list")
    public Page<ParticipationResponseVm> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        return participationService.getAll(page, size).map(participationMapper::toParticipationResponseVm);
    }

    @PostMapping("/create")
    public ResponseEntity<ParticipationResponseVm> createParticipation(@Valid @RequestBody ParticipationVm participationVm) {
        User user = userService.getById(participationVm.getUserId());
        Competition competition = competitionService.getById(participationVm.getCompetitionId());
        Participation participation = new Participation();
        participation.setUser(user);
        participation.setCompetition(competition);
        participation.setScore(participationVm.getScore());
        Participation savedParticipation = participationService.save(participation);
        return ResponseEntity.ok(participationMapper.toParticipationResponseVm(savedParticipation));
    }

    @GetMapping("/calculateScore/{id}")
    public ResponseEntity<ParticipationScoreResponseVm> calculateScore(@PathVariable UUID id) {
        Participation participation = participationService.getById(id);
        participationService.calculateScore(participation);
        return ResponseEntity.ok(participationMapper.toParticipationScoreResponseVm(participation));
    }


    @GetMapping("/getMyResult/{userId}")
    public Page<UserResultsResponseVm> deleteCompetition(@PathVariable UUID userId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        Page<Participation> participation = participationService.findByUserId(userId, page, size);
        return participation.map(participationMapper::toUserResultsResponseVm);
    }



}
