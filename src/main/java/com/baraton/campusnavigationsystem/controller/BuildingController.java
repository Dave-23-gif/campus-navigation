package com.baraton.campusnavigationsystem.controller;

import com.baraton.campusnavigationsystem.model.Building;
import com.baraton.campusnavigationsystem.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
@RequiredArgsConstructor
public class BuildingController {
    private final BuildingService buildingService;

    @GetMapping
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @PostMapping
    public Building addBuilding(@RequestBody Building building) {
        return buildingService.saveBuilding(building);
    }
}
