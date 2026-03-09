package com.baraton.campusnavigationsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "buildings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private String description;
}
