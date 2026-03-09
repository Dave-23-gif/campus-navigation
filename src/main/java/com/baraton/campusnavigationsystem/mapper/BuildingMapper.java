package com.baraton.campusnavigationsystem.mapper;

import com.baraton.campusnavigationsystem.dto.BuildingRequest;
import com.baraton.campusnavigationsystem.dto.BuildingResponse;
import com.baraton.campusnavigationsystem.model.Building;
import org.springframework.stereotype.Component;


@Component
public class BuildingMapper {
    public static BuildingRequest toEntity(BuildingRequest request){
        return new BuildingRequest(
                request.getName(),
                request.getLatitude(),
                request.getLongitude(),
                request.getDescription()
        );
    }
    public static BuildingResponse toResponse(Building building){
        return new BuildingResponse(
                building.getId(),
                building.getName(),
                building.getLatitude(),
                building.getLongitude(),
                building.getDescription()
        );
    }
}
