package org.rabie.hunters_league.web.api;

import org.rabie.hunters_league.service.ParticipationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/participation")
public class ParticipationController {
    private final ParticipationService participationService;
    private final ParticipationMapper participationMapper;

}
