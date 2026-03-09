package com.baraton.campusnavigationsystem.controller;

import com.baraton.campusnavigationsystem.dto.BuildingRequest;
import com.baraton.campusnavigationsystem.dto.BuildingResponse;
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
    public List<BuildingResponse> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @PostMapping
    public BuildingResponse addBuilding(@RequestBody BuildingRequest building) {
        return buildingService.saveBuilding(building);
    }
}
