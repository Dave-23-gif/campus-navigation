package com.baraton.campusnavigationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "paths")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "start_building_id")
    @JsonIgnore
    private Building startBuilding;
    @ManyToOne
    @JoinColumn(name = "end_building_id")
    @JsonIgnore
    private Building endBuilding;
    private int distance;


}
