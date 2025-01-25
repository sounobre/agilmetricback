package com.agilmetric.services;

import com.agilmetric.dto.RoadmapRequest;
import com.agilmetric.models.RoadmapModel;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface RoadmapService {

    List<RoadmapModel> findAll();
    RoadmapModel findById(UUID id);
    RoadmapModel save(RoadmapRequest request);
    RoadmapModel update(UUID id, RoadmapRequest request);
    void delete(UUID id);
}
