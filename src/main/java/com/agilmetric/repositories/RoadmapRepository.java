package com.agilmetric.repositories;

import com.agilmetric.models.RoadmapModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoadmapRepository extends JpaRepository<RoadmapModel, UUID> {
}
