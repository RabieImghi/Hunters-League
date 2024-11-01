package org.rabie.hunters_league.web.api;

import jakarta.validation.Valid;
import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.domain.Participation;
import org.rabie.hunters_league.domain.User;
import org.rabie.hunters_league.exceptions.CompetitionNotExistException;
import org.rabie.hunters_league.exceptions.LicenceUserExpiredException;
import org.rabie.hunters_league.exceptions.UserNotExistException;
import org.rabie.hunters_league.service.CompetitionService;
import org.rabie.hunters_league.service.ParticipationService;
import org.rabie.hunters_league.service.UserService;
import org.rabie.hunters_league.web.vm.mapper.ParticipationMapper;
import org.rabie.hunters_league.web.vm.request.ParticipationVm;
import org.rabie.hunters_league.web.vm.response.ParticipationResponseVm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/participation")
public class ParticipationController {
    private final ParticipationService participationService;
    private final ParticipationMapper participationMapper;
    private final CompetitionService competitionService;
    private final UserService userService;

    public ParticipationController(ParticipationService participationService, ParticipationMapper participationMapper, CompetitionService competitionService,
                                    UserService userService)
    {
        this.participationService = participationService;
        this.participationMapper = participationMapper;
        this.competitionService = competitionService;
        this.userService = userService;
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



}
