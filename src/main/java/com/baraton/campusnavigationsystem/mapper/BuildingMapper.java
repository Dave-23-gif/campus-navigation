package com.baraton.campusnavigationsystem.mapper;

import com.baraton.campusnavigationsystem.dto.BuildingRequest;
import com.baraton.campusnavigationsystem.dto.BuildingResponse;
import com.baraton.campusnavigationsystem.model.Building;
import org.springframework.stereotype.Component;


@Component
public class BuildingMapper {
    public  Building toEntity(BuildingRequest request){
        Building building= new Building();
               building.setName(request.getName());
               building.setDescription(request.getDescription());
               building.setLongitude(request.getLongitude());
               building.setLatitude(request.getLatitude());

               return building;

    }
    public  BuildingResponse toResponse(Building building){
        return new BuildingResponse(
                building.getId(),
                building.getName(),
                building.getLatitude(),
                building.getLongitude(),
                building.getDescription()
        );
    }
}
