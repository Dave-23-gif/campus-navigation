package com.baraton.campusnavigationsystem.repository;

import com.baraton.campusnavigationsystem.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
