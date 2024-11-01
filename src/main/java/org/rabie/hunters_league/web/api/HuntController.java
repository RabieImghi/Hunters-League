package org.rabie.hunters_league.web.api;

import org.rabie.hunters_league.service.HuntService;
import org.rabie.hunters_league.web.vm.mapper.HuntMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hunt")
public class HuntController {

    private final HuntService huntService;
    private final HuntMapper huntMapper;

    public HuntController(HuntService huntService, HuntMapper huntMapper) {
        this.huntService = huntService;
        this.huntMapper = huntMapper;
    }


}
