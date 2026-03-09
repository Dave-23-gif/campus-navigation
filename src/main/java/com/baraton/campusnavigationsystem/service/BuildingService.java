package com.baraton.campusnavigationsystem.service;

import com.baraton.campusnavigationsystem.model.Building;
import com.baraton.campusnavigationsystem.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingService {
    private final BuildingRepository buildingRepository;

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }
    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    }
}
