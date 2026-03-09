package com.baraton.campusnavigationsystem.service;

import com.baraton.campusnavigationsystem.dto.BuildingRequest;
import com.baraton.campusnavigationsystem.dto.BuildingResponse;
import com.baraton.campusnavigationsystem.mapper.BuildingMapper;
import com.baraton.campusnavigationsystem.model.Building;
import com.baraton.campusnavigationsystem.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuildingService {
    private final BuildingRepository buildingRepository;
    private final BuildingMapper buildingMapper;

    public List<BuildingResponse> getAllBuildings() {
        return buildingRepository.findAll()
                .stream()
                .map(building -> buildingMapper.toResponse(building))
                .collect(Collectors.toList());
    }
    public BuildingResponse saveBuilding(BuildingRequest request) {
        Building building =buildingMapper.toEntity(request);
        Building saved=buildingRepository.save(building);
        return buildingMapper.toResponse(saved);
    }
}
