package com.baraton.campusnavigationsystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuildingRequest {
    private String name;
    private double latitude;
    private double longitude;
    private String description;
}
