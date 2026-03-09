package com.baraton.campusnavigationsystem.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingResponse {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private String description;
}
