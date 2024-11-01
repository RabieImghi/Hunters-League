package org.rabie.hunters_league.web.api;

import org.rabie.hunters_league.service.SpeciesService;
import org.rabie.hunters_league.web.vm.mapper.SpeciesMapper;
import org.rabie.hunters_league.web.vm.response.ListSpeciesVm;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    private final SpeciesService speciesService;
    private final SpeciesMapper speciesMapper;
    public SpeciesController(SpeciesService speciesService, SpeciesMapper speciesMapper) {
        this.speciesService = speciesService;
        this.speciesMapper = speciesMapper;
    }

    @GetMapping("/list")
    public Page<ListSpeciesVm> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        return speciesService.getAll(page, size).map(speciesMapper::toListSpeciesVm);
    }
}
